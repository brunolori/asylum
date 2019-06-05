package al.gov.mb.asylum.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.gov.mb.asylum.constants.IDecisionStatus;
import al.gov.mb.asylum.constants.IDecisionType;
import al.gov.mb.asylum.dao.CrudDAO;
import al.gov.mb.asylum.dao.DecisionDAO;
import al.gov.mb.asylum.dto.DecisionDTO;
import al.gov.mb.asylum.entities.tims.Decision;
import al.gov.mb.asylum.entities.tims.DecisionHistory;
import al.gov.mb.asylum.entities.tims.DecisionReason;
import al.gov.mb.asylum.entities.tims.DecisionReasonPK;
import al.gov.mb.asylum.entities.tims.DecisionStatus;
import al.gov.mb.asylum.entities.tims.DecisionType;
import al.gov.mb.asylum.entities.tims.Selection;
import al.gov.mb.asylum.exceptions.ValidationException;
import al.gov.mb.asylum.utils.StringUtil;

@Service
public class DecisionService {
	
	
	@Autowired CrudDAO crudDAO;
	@Autowired DecisionDAO decisionDAO;
	
	
	
	@Transactional
	public Decision registerDecision(DecisionDTO dto, String uname)
	{
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
		
		if(dto.getDecisionType() == null)
		{
			throw new ValidationException("Zgjidhni tipin e vendimit");
		}
		
		if(!StringUtil.isValid(dto.getOrderNumber()))
		{
			throw new ValidationException("Plotesoni Nr e vendimit");
		}
		
		if(dto.getOrderDate() == null)
		{
			throw new ValidationException("Plotesoni daten e vendimit");
		}
		
		if(dto.getDecisionType().getId().equals(IDecisionType.F_DETENTION_ORDER))
		{
			if(!StringUtil.isValid(dto.getArticle()))
			{
				throw new ValidationException("Plotesoni Nenin");
			}
		}
		else
		{
			if(dto.getDayRemoval() == null || dto.getDayRemoval()<1)
			{
				throw new ValidationException("Plotesoni ditet per largim");
			}
			if(!StringUtil.isValid(dto.getBorderCrossingPoint()))
			{
				throw new ValidationException("Plotesoni PKK e daljes");
			}
			if(dto.getDatePermitEntrance() == null)
			{
				throw new ValidationException("Plotesoni daten e ndalimit te hyrjes");
			}
		}
		if(dto.getDecisionReason() == null)
		{
			throw new ValidationException("Plotesoni arsyen");
		}
				
		Decision decision = new Decision();
		if(dto.getDecisionType().getId().equals(IDecisionType.F_DETENTION_ORDER))
		{
			decision.setArticle(dto.getArticle());
		}
		else
		{
			decision.setBorderCrossingPoint(dto.getBorderCrossingPoint());
			decision.setDatePermitEntrance(dto.getDatePermitEntrance());
			decision.setDayRemoval(dto.getDayRemoval());	
		}
		
		decision.setOrderStatus(crudDAO.findById(DecisionStatus.class, IDecisionStatus.ACTIVE));
		decision.setDecisionReason(crudDAO.findById(DecisionReason.class, new DecisionReasonPK(dto.getDecisionReason().getCodeOrder(), dto.getDecisionReason().getTypeOrder())));
		decision.setDecisionType(crudDAO.findById(DecisionType.class, dto.getDecisionType().getId()));
		decision.setOrderDate(dto.getOrderDate());
		decision.setOrderNumber(dto.getOrderNumber());
		decision.setReason(dto.getReason());
		decision.setRecordDate(Calendar.getInstance().getTime());
		decision.setRecordUser(uname);
		decision.setSelection(crudDAO.findById(Selection.class, dto.getSelection().getEvent().getId()));
		
		return crudDAO.create(decision);
		
	}
	
	@Transactional
	public Decision modifyDecision(DecisionDTO dto, String uname)
	{
		if(dto.getSelection() == null)
		{
			throw new ValidationException("I perzgjedhuri i papercaktuar");
		}
		
		if(dto.getDecisionType() == null)
		{
			throw new ValidationException("Zgjidhni tipin e vendimit");
		}
		
		if(!StringUtil.isValid(dto.getOrderNumber()))
		{
			throw new ValidationException("Plotesoni Nr e vendimit");
		}
		
		if(dto.getOrderDate() == null)
		{
			throw new ValidationException("Plotesoni daten e vendimit");
		}
		
		if(dto.getDecisionType().getId().equals(IDecisionType.F_DETENTION_ORDER))
		{
			if(!StringUtil.isValid(dto.getArticle()))
			{
				throw new ValidationException("Plotesoni Nenin");
			}
		}
		else
		{
			if(dto.getDayRemoval() == null || dto.getDayRemoval()<1)
			{
				throw new ValidationException("Plotesoni ditet per largim");
			}
			if(!StringUtil.isValid(dto.getBorderCrossingPoint()))
			{
				throw new ValidationException("Plotesoni PKK e daljes");
			}
			if(dto.getDatePermitEntrance() == null)
			{
				throw new ValidationException("Plotesoni daten e ndalimit te hyrjes");
			}
		}
		if(dto.getDecisionReason() == null)
		{
			throw new ValidationException("Plotesoni arsyen");
		}
				
		Decision decision = crudDAO.findById(Decision.class, dto.getId());
		if(dto.getDecisionType().getId().equals(IDecisionType.F_DETENTION_ORDER))
		{
			decision.setArticle(dto.getArticle());
		}
		else
		{
			decision.setBorderCrossingPoint(dto.getBorderCrossingPoint());
			decision.setDatePermitEntrance(dto.getDatePermitEntrance());
			decision.setDayRemoval(dto.getDayRemoval());	
		}
		
		DecisionStatus oldStatus = decision.getOrderStatus();
		DecisionStatus newStatus = crudDAO.findById(DecisionStatus.class, dto.getOrderStatus().getId());
		
		decision.setOrderStatus(newStatus);
		decision.setDecisionReason(crudDAO.findById(DecisionReason.class, new DecisionReasonPK(dto.getDecisionReason().getCodeOrder(), dto.getDecisionReason().getTypeOrder())));
		decision.setDecisionType(crudDAO.findById(DecisionType.class, dto.getDecisionType().getId()));
		decision.setOrderDate(dto.getOrderDate());
		decision.setOrderNumber(dto.getOrderNumber());
		decision.setReason(dto.getReason());
		decision.setModifUser(uname);
		
		decision = crudDAO.update(decision);
		
		if(!oldStatus.getId().equals(newStatus.getId()))
		{
			DecisionHistory h = new DecisionHistory();
			h.setDecision(decision);
			h.setField("[STATUS:"+oldStatus.getTag()+" -> "+newStatus.getTag()+"]");
			h.setRecordDate(Calendar.getInstance().getTime());
			h.setRecordUser(uname);
			h.setNotes(null);
			crudDAO.create(h);
		}
		
		return decision;
		
		
		
	}
	
	
	
	public List<Decision> getEventDecisions(Integer eventId)
	{
		return decisionDAO.searchDecision(eventId);
	}
	

}
