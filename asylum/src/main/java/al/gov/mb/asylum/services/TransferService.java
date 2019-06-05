package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IOrganization;
import al.gov.mb.asylum.constants.IRole;
import al.gov.mb.asylum.constants.IStatus;
import al.gov.mb.asylum.constants.ITransferStatus;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.TransferDAO;
import al.gov.mb.asylum.dto.SelectionDTO;
import al.gov.mb.asylum.dto.TransferDTO;
import al.gov.mb.asylum.entities.AsylantDetails;
import al.gov.mb.asylum.entities.Transfer;
import al.gov.mb.asylum.entities.TransferStatus;
import al.gov.mb.asylum.entities.User;
import al.gov.mb.asylum.entities.tims.Organization;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.forms.TransferForm;
import al.gov.mb.asylum.forms.TransferSx;

@Service
public class TransferService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired TransferDAO transferDAO;
	
	
	
	@Transactional
	public Transfer registerCheckOut(TransferDTO dto, String uname)
	{
		
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
		if(dto.getToOrganization() == null)
		{
			throw new ValidationException("Zgjidhni Destinacionin");
		}
		
		AsylantDetails details = crudDAO.findById(AsylantDetails.class, dto.getSelection().getEvent().getId());
		
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.GONE)
		{
			throw new ValidationException("I perzgjedhuri eshte larguar");
		}
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.DEPARTED)
		{
			throw new ValidationException("I perzgjedhuri eshte nisur me perpara drejt "+details.getCurrentLocation().getTag());
		}
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.ARRIVED)
		{
			throw new ValidationException("I perzgjedhuri ka mberritur me perpara ne "+details.getCurrentLocation().getTag());
		}
		
		Selection selection = crudDAO.findById(Selection.class, dto.getSelection().getEvent().getId());
		
		Transfer trans = new Transfer();
		trans.setCheckOutTime(Calendar.getInstance().getTime());
		trans.setCheckOutUser(uname);
		trans.setCheckOutNotes(dto.getCheckOutNotes());
		trans.setFromOrganization(selection.getEvent().getOrganization());
		trans.setSelection(selection);
		trans.setStatus(IStatus.ACTIVE);
		trans.setToOrganization(crudDAO.findById(Organization.class, dto.getToOrganization().getId()));
		trans.setTransferStatus(crudDAO.findById(TransferStatus.class, ITransferStatus.DEPARTED));
		
		trans = crudDAO.create(trans);
		
		details.setCurrentLocation(trans.getToOrganization());
		details.setTransferStatus(trans.getTransferStatus());
		crudDAO.update(details);
		
		return trans;
	}
	
	@Transactional
	public void registerCheckOut(TransferForm form, String uname)
	{
		if(form.getDestinationOrgId() == null)
		{
			throw new ValidationException("Zgjidhni Destinacionin");
		}
		if(form.getSelections() == null || form.getSelections().isEmpty())
		{
			throw new ValidationException("Zgjidhni Personat per transferim");
		}
		
		Organization toOrg = crudDAO.findById(Organization.class, form.getDestinationOrgId());
		
		for(SelectionDTO dto : form.getSelections())
		{
			AsylantDetails details = crudDAO.findById(AsylantDetails.class, dto.getEvent().getId());
			
			if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.GONE)
			{
				throw new ValidationException("I perzgjedhuri "+ dto.getPerson().getName()+" "+dto.getPerson().getSurname()+" eshte larguar");
			}
			if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.DEPARTED)
			{
				throw new ValidationException("I perzgjedhuri "+ dto.getPerson().getName()+" "+dto.getPerson().getSurname()+" eshte nisur me perpara drejt "+details.getCurrentLocation().getTag());
			}
			if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.ARRIVED)
			{
				throw new ValidationException("I perzgjedhuri "+ dto.getPerson().getName()+" "+ dto.getPerson().getSurname()+" ka mberritur me perpara ne "+details.getCurrentLocation().getTag());
			}
			
			Selection selection = crudDAO.findById(Selection.class, dto.getEvent().getId());
			
			Transfer trans = new Transfer();
			trans.setCheckOutTime(Calendar.getInstance().getTime());
			trans.setCheckOutUser(uname);
			trans.setCheckOutNotes(form.getNotes());
			trans.setFromOrganization(selection.getEvent().getOrganization());
			trans.setSelection(selection);
			trans.setStatus(IStatus.ACTIVE);
			trans.setToOrganization(toOrg);
			trans.setTransferStatus(crudDAO.findById(TransferStatus.class, ITransferStatus.DEPARTED));
			
			trans = crudDAO.create(trans);
			
			details.setCurrentLocation(trans.getToOrganization());
			details.setTransferStatus(trans.getTransferStatus());
			crudDAO.update(details);
		}
	}
	
	
	@Transactional
	public Transfer completeCheckIn(TransferDTO dto, String uname)
	{
		
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
		
		if(dto.getTransferStatus().getId() == ITransferStatus.GONE)
		{
			throw new ValidationException("Perdor menune tjeter per te regjistruar largimin e personit");
		}
		
		AsylantDetails details = crudDAO.findById(AsylantDetails.class, dto.getSelection().getEvent().getId());		
		
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.GONE)
		{
			throw new ValidationException("I perzgjedhuri eshte larguar");
		}
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.ARRIVED)
		{
			throw new ValidationException("I perzgjedhuri ka mberritur me perpara ne "+details.getCurrentLocation().getTag());
		}
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.REJECTED)
		{
			throw new ValidationException("I perzgjedhuri eshte refuzuar dhe derguar perseri drejt "+details.getCurrentLocation().getTag());
		}
				
		Transfer trans = crudDAO.findById(Transfer.class, dto.getId());
		trans.setCheckInTime(Calendar.getInstance().getTime());
		trans.setCheckInUser(uname);
		trans.setCheckInNotes(dto.getCheckInNotes());
		trans.setTransferStatus(crudDAO.findById(TransferStatus.class, dto.getTransferStatus().getId()));
		
		trans = crudDAO.update(trans);
		if(dto.getTransferStatus().getId() == ITransferStatus.REJECTED)
		{
		   details.setCurrentLocation(trans.getFromOrganization());
		}
		else if(dto.getTransferStatus().getId() == ITransferStatus.ARRIVED)
		{
			details.setCurrentLocation(trans.getToOrganization());
		}
		details.setTransferStatus(trans.getTransferStatus());
		crudDAO.update(details);
		
		return trans;
	}
	
	@Transactional
	public Transfer registerGoneSelection(SelectionDTO dto, String uname)
	{
		if(dto == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
	
		User u = crudDAO.findById(User.class, uname);
		
		AsylantDetails details = crudDAO.findById(AsylantDetails.class, dto.getEvent().getId());		
		
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.GONE)
		{
			throw new ValidationException("I perzgjedhuri eshte larguar me perpara");
		}
		
		
		Organization gone = crudDAO.findById(Organization.class, IOrganization.GONE_ID);
		
		Transfer trans = new Transfer();
		trans.setSelection(crudDAO.findById(Selection.class, dto.getEvent().getId()));
		trans.setStatus(IStatus.ACTIVE);
		
		if(details.getTransferStatus() != null && details.getTransferStatus().getId() == ITransferStatus.DEPARTED)
		{
			TransferSx req = new TransferSx();
			req.setTransferStatusId(ITransferStatus.DEPARTED);
			req.setSelectionId(dto.getEvent().getId());
			List<Transfer> transfers = transferDAO.searchTransfer(req);
			if(transfers != null && !transfers.isEmpty())
			{
				Transfer t = transfers.get(0);
				t.setCheckOutNotes("Larguar nga "+u.getOrganization().getTag());
				t.setCheckOutTime(Calendar.getInstance().getTime());
				t.setCheckOutUser(uname);
				t.setTransferStatus(crudDAO.findById(TransferStatus.class, ITransferStatus.GONE));
				trans = crudDAO.update(t);
			}
			else
			{
				trans.setFromOrganization(u.getOrganization());
				trans.setToOrganization(gone);
				trans.setCheckOutNotes("Larguar nga "+u.getOrganization().getTag());
				trans.setCheckOutTime(Calendar.getInstance().getTime());
				trans.setCheckOutUser(uname);
				trans.setTransferStatus(crudDAO.findById(TransferStatus.class, ITransferStatus.GONE));
				
				trans = crudDAO.create(trans);
			}
		}		
		else {		
				trans.setFromOrganization(u.getOrganization());
				trans.setToOrganization(gone);
				trans.setCheckOutNotes("Larguar nga "+u.getOrganization().getTag());
				trans.setCheckOutTime(Calendar.getInstance().getTime());
				trans.setCheckOutUser(uname);
				trans.setTransferStatus(crudDAO.findById(TransferStatus.class, ITransferStatus.GONE));
				
				trans = crudDAO.create(trans);
		}
		
		details.setCurrentLocation(gone);
		details.setTransferStatus(trans.getTransferStatus());
		
		crudDAO.update(details);
		
		return trans;
	}
	
	public List<Transfer> getSelectionTransfers(Integer eventId)
	{
		TransferSx req = new TransferSx();
		req.setSelectionId(eventId);
		return transferDAO.searchTransfer(req);
	}
	
	
	public List<Transfer> searchTransfer(TransferSx req, String uname)
	{
		
		User u = crudDAO.findById(User.class, uname);
		
		if(u.getRole().equals(IRole.DRKM))
		{
			if(!u.getOrganization().getCentral().equals(IOrganization.CENTRAL))
			{
				req.setDepartureOrganizationId(u.getOrganization().getId());
			}
		}
		else if(u.getRole().equals(IRole.QKPA))
		{
			req.setDestinationOrganizationId(u.getOrganization().getId());
		}
		
		return transferDAO.searchTransfer(req);
	}
	
	public List<Transfer> searchGone(TransferSx req, String uname)
	{
		
		req.setTransferStatusId(ITransferStatus.GONE);
		
		return transferDAO.searchTransfer(req);
	}
	
	public List<Selection> getDrkmSelectionsForTransfer(String uname)
	{
		User u = crudDAO.findById(User.class, uname);
		Integer orgId = u.getOrganization().getId();
		
		return transferDAO.getDrkmSelectionsForTransfer(orgId);
		
	}
	
	
	

}
