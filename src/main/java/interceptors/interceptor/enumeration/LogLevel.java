package interceptors.interceptor.enumeration;

public enum LogLevel {

	/**
	 * Define that the being logged message is an error
	 */
	ERROR,
	/**
	 * Define that the being logged message is critical and should not be ignored
	 */
	WARN,

	/**
	 * Define that the being logged message is important and need special care
	 */
	INFO,

	/**
	 * Define that the being logged message is normal and no real attention is
	 * required
	 */
	DEBUG,

	/**
	 * Define that the being logged message is for information only and no attention
	 * is required
	 */
	TRACE;
}