package com.mkyong.web.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

public class PojoBase {
	private Date created = new Date();
	private String createdBy = "";
	private Date updated = new Date();
	private String updatedBy = "";

	protected PojoBase() {
	}

	/**
	 * @param createdBy
	 */
	public PojoBase(String createdBy) {
		this.createdBy = createdBy;
		this.updatedBy = createdBy;
	}

	/**
	 * @return the Created Date
	 */
	@JsonIgnore
	@XmlTransient
	public Date getCreated() {
		return created;
	}

	/**
	 * Set the created date
	 *
	 * @param created
	 */
	@SuppressWarnings("unused")
	private void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the Created by String
	 */
	@JsonIgnore
	@XmlTransient
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Set the created by
	 *
	 * @param createdBy
	 */
	@SuppressWarnings("unused")
	private void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the Updated Date
	 */
	@JsonIgnore
	@XmlTransient
	public Date getUpdated() {
		return updated;
	}

	/**
	 * Set the updated date
	 *
	 * @param updated
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * @return the UpdatedBy Name
	 */
	@JsonIgnore
	@XmlTransient
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the UpdatedBy name
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
