
package aligangajeswel;


import java.sql.Date;

public class JobApplication {
    private int id;
    private int applicantId;
    private String jobTitle;
    private Date applicationDate;
    private String status;

    public JobApplication(int id, int applicantId, String jobTitle, Date applicationDate, String status) {
        this.id = id;
        this.applicantId = applicantId;
        this.jobTitle = jobTitle;
        this.applicationDate = applicationDate;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", jobTitle='" + jobTitle + '\'' +
                ", applicationDate=" + applicationDate +
                ", status='" + status + '\'' +
                '}';
    }
}