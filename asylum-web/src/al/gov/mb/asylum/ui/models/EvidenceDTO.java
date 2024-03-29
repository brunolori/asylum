package al.gov.mb.asylum.ui.models;

import java.io.Serializable;
import java.util.Date;





public class EvidenceDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
		private int evidenceId;
	    private int eventId;
	    private String name;
	    private String description;
	    private Date recordDate;
	    private String modifUser;
	    private String recordUser;
	    private EventDTO event;
	    
	    
		public int getEvidenceId() {
			return evidenceId;
		}
		public void setEvidenceId(int evidenceId) {
			this.evidenceId = evidenceId;
		}
		public int getEventId() {
			return eventId;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getRecordDate() {
			return recordDate;
		}
		public void setRecordDate(Date recordDate) {
			this.recordDate = recordDate;
		}
		public String getModifUser() {
			return modifUser;
		}
		public void setModifUser(String modifUser) {
			this.modifUser = modifUser;
		}
		public String getRecordUser() {
			return recordUser;
		}
		public void setRecordUser(String recordUser) {
			this.recordUser = recordUser;
		}
		public EventDTO getEvent() {
			return event;
		}
		public void setEvent(EventDTO event) {
			this.event = event;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EvidenceDTO other = (EvidenceDTO) obj;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

	    
	    

}
