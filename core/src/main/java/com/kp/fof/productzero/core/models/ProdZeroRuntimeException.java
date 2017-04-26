/**
 * 
 */
package com.kp.fof.productzero.core.models;

/**
 * @author girish
 *
 */
public class ProdZeroRuntimeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ProdZeroRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ProdZeroRuntimeException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ProdZeroRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ProdZeroRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super();
	}

}
