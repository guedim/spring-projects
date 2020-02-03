/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.model;

/**
 * Define the Email Template Key used in the system.
 *
 * @author <a href="mario.guerrero@payulatam.com">Mario Guerrero</a>
 * @date 9/11/2010
 * @version 4.9.18
 */
public enum EmailTemplateKey {
	
	/**
	 * Templates for requesting approval to remove account customization
	 */
	HACKATHON_PAYMENTS_METHODS_EQUILIZER,

	/**
	 * Template for TEST email services.
	 */
	TEST_TEMPLATE,

	/**
	 * Template is sent to confirm the merchant when transaction is approved.
	 */
	TRANSACTION_APPROVED_SELLER,

	/**
	 * Template is sent to confirm the buyer when transaction is approved.
	 */
	TRANSACTION_APPROVED_BUYER,

	/**
	 * Template is sent to the merchant when the transaction is rejected.
	 */
	TRANSACTION_REJECTED_SELLER,

	/**
	 * Template is sent to the buyer when the transaction is rejected.
	 */
	TRANSACTION_REJECTED_BUYER,

	/**
	 * Template is sent to the merchant when the transaction is expired.
	 */
	TRANSACTION_EXPIRED_SELLER,

	/**
	 * Template is sent to the buyer when the transaction is expired.
	 */
	TRANSACTION_EXPIRED_BUYER,

	/**
	 * Template is sent to the merchant when the transaction is in validation.
	 */
	TRANSACTION_IN_VALIDATION_SELLER,

	/**
	 * Template is sent to the buyer when the transaction is in validation.
	 */
	TRANSACTION_IN_VALIDATION_BUYER,

	/**
	 * Template is sent when confirmation page fails.
	 */
	CONFIRMATION_PAGE_ERROR,

	/**
	 * Template is sent to the merchant when the Merchant is created.
	 */
	MERCHANT_CREATION,

	/**
	 * Template is sent to the commercial when the Merchant is created.
	 */
	MERCHANT_CREATION_COPY_TO_COMMERCIAL,

	/**
	 * Template is sent to Billing when the Merchant is created.
	 */
	MERCHANT_CREATION_COPY_TO_BILLING,

	/**
	 * Template is sent to post sales when the Merchant is created.
	 */
	MERCHANT_CREATION_COPY_TO_POST_SALES,

	/**
	 * Template is sent when a webUser is created
	 */
	WEB_USER_CREATION,

	/**
	 * Template to send secure contact us email.
	 */
	SECURE_CONTACT_US,

	/**
	 * Template to confirm the contact email.
	 */
	CONFIRMATION_SECURE_CONTACT_US,

	/**
	 * The email for activating the webUser's password.
	 */
	EMAIL_ACTIVATION_PASSWORD,

	/**
	 * The email for unlock the webUser's account.
	 */
	EMAIL_UNLOCK_USER,

	/**
	 * The first contact of the implementation engineer with the merchant
	 */
	FIRST_CONTACT_CLIENT,

	/**
	 * The transaction verified in the MAF system is in invalid state.
	 */
	VERIFIED_MAF_ORDER_INVALID_STATE,

	/**
	 * Template is sent when a payment order is created in the system.
	 */
	CREATED_PAYMENT_ORDER,

	/**
	 * Template is sent in order to validate email when online account is being
	 * created.
	 */
	ONLINE_ACCOUNT_MAIL_VALIDATION,

	/**
	 * Template is sent when a webuser request to create a bank in the system.
	 */
	ONLINE_ACCOUNT_CREATE_BANK,

	/**
	 * An error occurred in the cron job system.
	 */
	EXCEPTION_CRON_JOB,

	/**
	 * Template name for email when the service creates a new the payment request by
	 * link.
	 */
	EMAIL_PAYMENT_REQUEST_LINK_DETAILED_CREATED,

	/**
	 * Template name for email when the service reminds a payment request by link
	 */
	EMAIL_PAYMENT_REQUEST_LINK_DETAILED_REMINDER,

	/**
	 * Template is sent when exist differences in processed transactions after
	 * common conciliation process.
	 */
	GENERIC_CONCILIATION_EMAIL_ALERT,

	/**
	 * Template is sent when exist error in retrieves from server ftp or sending
	 * file to server ftp
	 */
	CONCILIATION_PROCESS_ERROR_EMAIL_ALERT,

	/**
	 * Template used to build a report with the reconciliation errors over both
	 * orders, coupons or payments cards.
	 */
	BUSINESS_UNIT_CONCILIATION_EMAIL_ALERT,

	/**
	 * Template name for email when the service creates a new the payment request
	 * detailed by billing.
	 */
	EMAIL_PAYMENT_REQUEST_LINK_DETAILED_BY_BILLING_CREATED,

	/**
	 * Template name for email when the service create a payment request detailed by
	 * mail
	 */
	EMAIL_PAYMENT_REQUEST_MAIL_DETAILED_CREATED,

	/**
	 * Template name for email when the service sends a remainder for a payment
	 * request detailed by mail
	 */
	EMAIL_PAYMENT_REQUEST_MAIL_DETAILED_REMAINDER,

	/**
	 * Template name for email for notifications to merchant.
	 */
	EMAIL_PAYMENT_REQUEST_NOTIFICATION_FOR_MERCHANT,

	/**
	 * Template name for email for notifications of canceling of payment merchant
	 * tools.
	 */
	EMAIL_PAYMENT_MERCHANT_TOOLS_CANCEL_NOTIFICATION,

	/**
	 * Template is sent to the merchant when a payment order is created in the
	 * system.
	 */
	CONFIRM_PAYMENT_ORDER,

	/**
	 * Template is sent to the merchant when the transaction is rejected and payment
	 * method is Referenced Payment.
	 */
	TRANSACTION_REJECTED_REFERENCED_PAYMENT_SELLER,

	/**
	 * Template is sent to the buyer when the transaction is rejected and payment
	 * method is Referenced Payment.
	 */
	TRANSACTION_REJECTED_REFERENCED_PAYMENT_BUYER,

	/**
	 * Template is sent when an user creates an online account
	 */
	ONLINE_ACCOUNT_CREATION,

	/**
	 * Template name to be used by email service when an account transfer is made
	 * ​​from an account.
	 */
	ACCOUNT_TRANSFER_MADE,

	/**
	 * Template name to be used by email service when an account transfer is
	 * received ​​from an account.
	 */
	ACCOUNT_TRANSFER_RECEIVED,

	/**
	 * Template name to be used by email service for make a notification to a buyer
	 * using Online Processing functionality
	 */
	TRANSACTION_IN_VALIDATION_BUYER_ONLINE_PROCESSING,

	/**
	 * Template is sent when an user process the first transaction
	 */
	ONLINE_ACCOUNT_FIRST_TRANSACTION,

	/**
	 * Template is sent when an account reach a number of approved transactions
	 */
	ONLINE_ACCOUNT_NUMBER_TRANSACTIONS,

	/**
	 * Template is sent when an account reach a minimum TPV (accumulated of approved
	 * transactions)
	 */
	ONLINE_ACCOUNT_TPV_TRANSACTIONS,

	/**
	 * Template for subscription successful payment merchant notification.
	 */
	RECURRING_PAYMENT_SUCCESSFUL_MERCHANT,

	/**
	 * Template for subscription successful payment customer notification.
	 */
	RECURRING_PAYMENT_SUCCESSFUL_CUSTOMER,

	/**
	 * Email template used to build the merchant's email when in a recurring payment
	 * a transaction fails and the subscription doesn't have retry
	 */
	RECURRING_BILL_PAYMENT_FAIL_MERCHANT,

	/**
	 * Email template used to build the customer's email when in a recurring payment
	 * a transaction fails and the subscription doesn't have retry
	 */
	RECURRING_BILL_PAYMENT_FAIL_CUSTOMER,

	/**
	 * Email template used to build the merchant's email when in a recurring payment
	 * a transaction fails and the subscription have at lease one retry left.
	 */
	RECURRING_BILL_PAYMENT_FAIL_AND_RETRY_MERCHANT,

	/**
	 * Email template used to build the customer's email when in a recurring payment
	 * a transaction fails and the subscription have at lease one retry left.
	 */
	RECURRING_BILL_PAYMENT_FAIL_AND_RETRY_CUSTOMER,

	/**
	 * Email template is sent to notify credit card expirations to the merchant
	 */
	CREDIT_CARD_EXPIRATION_MERCHANT,

	/**
	 * Email template is sent to notify credit card expirations to the customer
	 */
	CREDIT_CARD_EXPIRATION_CUSTOMER,

	/**
	 * Email template is sent to notify the cancellation of a subscription to the
	 * customer
	 */
	CANCEL_SUBSCRIPTION_CUSTOMER,

	/**
	 * Email template is sent to request documentation to seller
	 */
	CHARGEBACK_REQUEST_FOR_DOCUMENTATION_SELLER,

	/**
	 * Email template is sent to request documentation to buyer
	 */
	CHARGEBACK_REQUEST_FOR_DOCUMENTATION_BUYER,

	/**
	 * Template used to build the merchants's email when a transaction of type
	 * AUTHORIZATION was approved.
	 */
	AUTHORIZATION_APPROVED_MERCHANT,

	/**
	 * Template used to build the customer's email when a transaction of type
	 * AUTHORIZATION was approved.
	 */
	AUTHORIZATION_APPROVED_CUSTOMER,

	/**
	 * Template used to build the buyer's or payer's email when a transaction of
	 * type AUTHORIZATION AND CAPTURE is pending.
	 */
	CASH_PENDING_TRANSACTION,

	/**
	 * Template used to build the buyer's email when a transaction of type
	 * AUTHORIZATION AND CAPTURE is pending, Applies for Mexico.
	 */
	CASH_REFERENCED_PENDING_TRANSACTION_BUYER,

	/**
	 * Template used to build the buyer's email when a payment coupon is created.
	 */
	CREATE_COUPON,

	/**
	 * Template used to send barcode payment reference.
	 */
	CREATE_COUPON_BARCODE,

	/**
	 * Template used to build the merchant's email when a payment card request is
	 * created.
	 */
	CREATE_PAYMENT_CARD_REQUEST,

	/**
	 * Template used to build the merchant's email when a payment card request is
	 * shipped.
	 */
	SHIPPED_PAYMENT_CARDS,

	/**
	 * Email template is sent to notify the cancellation of a subscription to the
	 * merchant
	 */
	CANCEL_SUBSCRIPTION_CUSTOMER_TO_MERCHANT,

	/**
	 * Template used to build the notification of the bank accounts and Transactions
	 * of ACH Debits without response from the bank.
	 */
	ACH_DEBIT_NO_RESPONSE,

	/**
	 * Template used when a merchant rejects terms and conditions;
	 */
	MERCHANT_REJECTS_TERMS_CONDITIONS,

	/**
	 * Template used to build the buyer's email when a payment by cash on delivery
	 */
	CASH_ON_DELIVERY_REGISTRED_ORDER,

	/**
	 * Template used to build the buyer's email when the Cash On Delivery order is
	 * shipped.
	 */
	CASH_ON_DELIVERY_SHIPPED,

	/**
	 * Template used when a counter-charge is notified
	 */
	TRANSACTION_COUNTERCHARGE_NOTIFICATION,

	/**
	 * Used to inform to SAC the transactions that haven't been reconciled to date
	 */
	PENDING_FOR_CONCILIATION,

	/**
	 * Template used to build the email with the change state inconsistency report.
	 */
	CASH_ON_DELIVERY_CHANGE_STATE_INCONSISTENCY_REPORT,

	/** Email template used to send the Asobancaria reports to the merchants. */
	ASOBANCARIA_REPORT_EMAIL,

	/**
	 * Template is sent when a workflow processor fails
	 */
	WORKFLOW_PROCESSING_EXCEPTION,

	/**
	 * Template to notify errors in chargeback masive notification process
	 */
	CHARGEBACK_MASIVE_NOTIFICATION_ERRORS,

	/**
	 * Template to notify activation all payment methods for Peru merchant.
	 */
	ACTIVATION_PAYMENT_METHODS_PE_NOTIFICATION,

	/**
	 * Template to notify a chargeback process to payer
	 */
	PAYER_CHARGEBACK_NOTIFICATION,

	/**
	 * Template to notify errors in massive confirmation page process
	 */
	CONFIRMATION_PAGE_MASSIVE_NOTIFICATION_ERRORS,

	/**
	 * Template to confirm merchant that has accepted platform's terms and
	 * conditions.
	 */
	MERCHANT_TERMS_COND_ACCEPTANCE_TEMPLATE,

	/**
	 * Template to notify a refund or a void applied to a transaction
	 */
	REFUND_NOTIFICATION,

	/**
	 * Template to notify a partial refund
	 */
	PARTIAL_REFUND_NOTIFICATION,

	/**
	 * Template to notify a chargeback applied to a transaction
	 */
	CHARGEBACK_NOTIFICATION,

	/**
	 * Template to send and notify a customer's reconciliation
	 */
	RECONCILIATION_FILE_EMAIL,

	/**
	 * Template to send and notify a customer's transactions report
	 */
	TRANSACTIONS_FILE_EMAIL,

	/**
	 * Template to welcome the merchant
	 */
	ONLINE_ACCOUNT_WELCOME,

	/**
	 * Template to the merchant that its documents are in validation process
	 */
	ONLINE_ACCOUNT_DOCUMENTS_VALIDATION,

	/**
	 * Template to notify the files reconciled
	 */
	EMAIL_RECONCILIATION_NOTIFICATION,

	/**
	 * Template to notify a successful reversal of a postvalidation process
	 */
	SUCCESSFUL_REVERSAL_POSTVALIDATION_TEMPLATE,

	/**
	 * Template to notify a failed reversal of a postvalidation process
	 */
	FAILED_REVERSAL_POSTVALIDATION_TEMPLATE,

	/**
	 * Template to notify an approval of a postvalidation process
	 */
	APPROVAL_POSTVALIDATION_TEMPLATE,

	/**
	 * Template to notify the automatic transfer request
	 */
	NOTIFICATION_TRANSFER_REQUEST,

	/**
	 * Template to warn about days without transfers
	 */
	WARNING_TRANSFER,

	/**
	 * Template to confirm credit card registration to payer (PAYU CLICK)
	 */
	CONFIRM_CREDIT_CARD_REGISTRATION_TO_PAYER,

	/**
	 * Template to confirm credit card elimination to payer (PAYU CLICK)
	 */
	CONFIRM_CREDIT_CARD_ELIMINATION_PAYU_CLICK,

	/**
	 * Template to request credit card elimination to payer (PAYU CLICK)
	 */
	CREDIT_CARD_ELIMINATION_PAYU_CLICK,

	/**
	 * Template to confirm transaction cancelled (COD). To send to Buyer
	 */
	TRANSACTION_CANCELLED_BUYER,

	/**
	 * Template to confirm transaction cancelled (COD). To send to seller
	 */
	TRANSACTION_CANCELLED_SELLER,

	/**
	 * Template to notify the account activation
	 */
	ONLINE_ACCOUNT_APPROVED,

	/**
	 * Template to notify the account keeping
	 */
	ONLINE_ACCOUNT_DETAINED,

	/**
	 * Template to notify the account rejection
	 */
	ONLINE_ACCOUNT_REJECTED,

	/**
	 * Template to notify the processed transactions of captured and declined orders
	 * to migrated POL merchants
	 */
	POL_HTML_TRANSACTIONS_REPORT,

	/**
	 * Template to send the authentication security code to the payer
	 */
	PAYER_AUTHENTICATION_SECURITY_CODE,

	/**
	 * Template used to build the buyer's or payer's email when a transaction of
	 * type AUTHORIZATION AND CAPTURE is pending, and the payment method is
	 * PAGOEFECTIVO.
	 */
	CASH_PENDING_TRANSACTION_PAGOEFECTIVO,

	/**
	 * Template for expired transaction approved (seller).
	 */
	EXPIRED_TRANSACTION_APPROVED_SELLER,

	/**
	 * Template for expired transaction approved (buyer).
	 */
	EXPIRED_TRANSACTION_APPROVED_BUYER,

	/**
	 * Template for the lending transaction approved (buyer).
	 */
	LENDING_TRANSACTION_APPROVED_BUYER,

	/**
	 * Template to confirm transfers (seller)
	 */
	PAYMENT_ORDER_REQUEST_CONFIRMED,

	/**
	 * Template to confirm transfers associated to refunds (buyer/payer)
	 */
	PAYMENT_ORDER_REQUEST_FOR_REFUND_CONFIRMED,

	/**
	 * Template to rejected transfers request (seller)
	 */
	PAYMENT_ORDER_REQUEST_REJECTED,

	/**
	 * Template to rejected confirmed transfers request (seller)
	 */
	PAYMENT_ORDER_REQUEST_ERROR,

	/**
	 * Template for inconsistent transactions approved (conciliation team).
	 */
	INCONSISTENT_TRANSACTIONS_APPROVED_CONCILIATION,

	/**
	 * Template for exceptions generated in loan payment process.
	 */
	LENDING_LOAN_PAYMENT_EXCEPTIONS,

	/**
	 * Template for exceptions generated in invoicing process.
	 */
	LENDING_INVOICING_EXCEPTIONS,

	/**
	 * Template for recurrent lending payer registration
	 */
	CONFIRM_RECURRENT_LENDING_PAYER_INFORMATION_REGISTRATION,

	/**
	 * Template for recurrent lending payer elimination
	 */
	CONFIRM_RECURRENT_LENDING_PAYER_INFORMATION_ELIMINATION,

	/**
	 * Template for duplicate orders (Seller).
	 */
	CASH_PAYMENT_DUPLICATE_ORDER_SELLER,

	/**
	 * Template for duplicate orders (Buyer).
	 */
	CASH_PAYMENT_DUPLICATE_ORDER_BUYER,

	/**
	 * Template for spei transaction mail.
	 */
	SPEI_TRANSACTION_MAIL_TO_PAYER,

	/**
	 * 
	 * Template for reminder mail to spei payer.
	 */
	SPEI_REMINDER_MAIL_TO_PAYER,

	/**
	 * Template for dispersion of funds (seller).
	 */
	DISPERSION_FUNDS_TRANSACTION_APPROVED_SELLER,

	/**
	 * Template for dispersion of funds (buyer).
	 */
	DISPERSION_FUNDS_TRANSACTION_APPROVED_BUYER,

	/**
	 * Email template to notify when files of novelty, pre-notifications, debit are
	 * ready to download
	 */
	ACH_DEBIT_DOWNLOAD_FILE_NOTIFICACION,

	/**
	 * Email notification when finish the process file response
	 */
	ACH_DEBIT_PROCESSING_RESPONSE_FILE_NOTIFICATION,

	/**
	 * Email notification to reconciliation process to Amex Argentina
	 */
	RECONCILIATION_NOTIFICATION_AMEX,

	/**
	 * Email notifying you if you exceeded the amount allowed to create
	 * discretionary movements
	 */
	ALERT_DISCRETIONARY_MOVEMENTS;

}