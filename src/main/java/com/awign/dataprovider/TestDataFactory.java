package com.awign.dataprovider;


public class TestDataFactory {
    private String customerMobileNumber;
    private String testCaseId;
    private String usr_id;
	private String usr_name;
    private String usr_email;
    private String usr_contact;
    private String org_name;
    private String org_domain;
    private String org_id;
    private String req_id;
    private String req_status;
	private String req_vertical;
	private String usr_cookie;
	private String client;
	private String access_token;
	private String uid;
	private String user_role;
	private String billingproject_id;
	private String executionproject_id;
	private String bpep_name;
	private String worklistings_id;


	private String worklistings_listing_type;
	private String worklistings_name;
	private String worklistings_location_type;
	private String project_execution_source_id;
	private String ep_Executive_execution_sources_id; //get from getProject using ep id
	private String ep_projectowner_execution_sources_id; //get from getProject using ep id
	private String listingsrc_execution_project_id; // get from listing search
	private String clone_listing_id;

	public String getEp_projectowner_execution_sources_id() {
		return this.ep_projectowner_execution_sources_id;
	}

	public void setEp_projectowner_execution_sources_id(String ep_projectowner_execution_sources_id) {
		this.ep_projectowner_execution_sources_id = ep_projectowner_execution_sources_id;
	}


	public String getclone_listing_id() {
		return this.clone_listing_id;
	}

	public void setclone_listing_id(int clone_listing_id) {
		this.clone_listing_id = String.valueOf(clone_listing_id);
	}

	

	public String getListingsrc_execution_project_id() {
		return this.listingsrc_execution_project_id;
	}

	public void setListingsrc_execution_project_id(String listingsrc_execution_project_id) {
		this.listingsrc_execution_project_id = listingsrc_execution_project_id;
	}

	public String getEp_Executive_execution_sources_id() {
		return this.ep_Executive_execution_sources_id;
	}

	public void setEp_Executive_execution_sources_id(String ep_Executive_execution_sources_id) {
		this.ep_Executive_execution_sources_id = ep_Executive_execution_sources_id;
	}

	public String getProject_execution_source_id() {
		return this.project_execution_source_id;
	}

	public void setProject_execution_source_id(String project_execution_source_id) {
		this.project_execution_source_id = project_execution_source_id;
	}

	public String getBpep_name() {
		return this.bpep_name;
	}

	public void setBpep_name(String bpep_name) {
		this.bpep_name = bpep_name;
	}

	public String getExecutionproject_id() {
		return this.executionproject_id;
	}

	public void setExecutionproject_id(String executionproject_id) {
		this.executionproject_id = executionproject_id;
	}

	public String getBillingproject_id() {
		return this.billingproject_id;
	}

	public void setBillingproject_id(String billingproject_id) {
		this.billingproject_id = billingproject_id;
	}

	public String getUser_role() {
		return this.user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getAccess_token() {
		return this.access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}




	

    
    
    public String getUsr_id() {
		return this.usr_id;
	}

	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}

    
	public String getUsr_cookie() {
		return this.usr_cookie;
	}

	public void setUsr_cookie(String usr_cookie) {
		this.usr_cookie = usr_cookie;
	}

	public String getTestCaseId() {
        return this.testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getCustomerMobileNumber() {
        return this.customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }
    
    public String getUsr_name() {
    	return this.usr_name;
    }
    
    public void setUsr_name(String usr_name) {
    	this.usr_name = usr_name;
    }
    public String getUsr_email() {
    	return this.usr_email;
    }
    
    public void setUsr_email(String usremail) {
    	this.usr_email = usremail;
    }

    public String getUsr_contact() {
    	return usr_contact;
    }
    
    public void setUsr_contact(String usrcontact) {
    	this.usr_contact = usrcontact;
    }

    public String getOrg_name() {
    	return this.org_name;
    }
    
    public void setOrg_name(String orgname) {
    	this.org_name = orgname;
    }

    public String getOrg_domain() {
    	return this.org_domain;
    }
    
    public void setOrg_domain(String orgdomain) {
    	this.org_domain = orgdomain;
    }
    
    public String getOrg_id() {
        return this.org_id;
    }

    public void setOrg_id(String orgid) {
        this.org_id = orgid;
    }

    public String getReq_id() {
		return this.req_id;
	}

	public void setReq_id(String req_id) {
		this.req_id = req_id;
	}

    public String getReq_status() {
		return this.req_status;
	}

	public void setReq_status(String req_status) {
		this.req_status = req_status;
	}

	public String getReq_vertical() {
		return this.req_vertical;
	}

	public void setReq_vertical(String req_vertical) {
		this.req_vertical = req_vertical;
	}

	
	public String getWorklistings_id() {
		return this.worklistings_id;
	}

	public void setWorklistings_id(String worklistings_id) {
		this.worklistings_id = worklistings_id;
	}

	public String getWorklistings_listing_type() {
		return this.worklistings_listing_type;
	}

	public void setWorklistings_listing_type(String worklistings_listing_type) {
		this.worklistings_listing_type = worklistings_listing_type;
	}

	public String getWorklistings_name() {
		return this.worklistings_name;
	}

	public void setWorklistings_name(String worklistings_name) {
		this.worklistings_name = worklistings_name;
	}

	public String getWorklistings_location_type() {
		return this.worklistings_location_type;
	}

	public void setWorklistings_location_type(String worklistings_location_type) {
		this.worklistings_location_type = worklistings_location_type;
	}



    
    @Override
    public String toString() {
        return " {" +
                "testCaseId='" + testCaseId + '\'' +
                '}';
    }    
    
}
