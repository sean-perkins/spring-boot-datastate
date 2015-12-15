package com.maestro.example;
/**
 * Example Super Class
 * 
 * @author  Sean Perkins <sean@meetmaestro.com>
 * @since   12/14/2015
 * @version 1.0.0
 *
 */
public class ExampleObject {

	protected long createdAt;
	protected long updatedAt;
	protected long deletedAt;
	
	public long getCreatedAt() {
		return createdAt;
	}
	
	public long getLastModifiedAt() {
		return updatedAt;
	}
	
	public void setLastModifiedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public long getDeletedAt() {
		return deletedAt;
	}
	
	public boolean isDeleted() {
		return deletedAt > 0;
	}
	
	public void delete() {
		deletedAt = System.currentTimeMillis();
	}

}
