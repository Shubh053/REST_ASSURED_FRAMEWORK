package com.rmgy.pojoclass;

public class ProjectLibrary {
	//create the global variable

	String createdBy;
	String projectName;
	String status;
	int teamSize;

	//use constructor
	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) {
	super();
	this.createdBy = createdBy;
	this.projectName = projectName;
	this.status = status;
	this.teamSize = teamSize;
	}
	
	//use getter and setter to access the variables
		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getTeamSize() {
			return teamSize;
		}

		public void setTeamSize(int teamSize) {
			this.teamSize = teamSize;
		}
}
