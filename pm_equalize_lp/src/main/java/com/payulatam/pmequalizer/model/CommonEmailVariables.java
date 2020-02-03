/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payulatam.com
 */
package com.payulatam.pmequalizer.model;

/**
 * Custom email variables class
 * 
 * @author <a href="diego.agudelo@payulatam.com">Diego Agudelo</a>
 * @author <a href="sergio.leottau@payulatam.com">Sergio Leottau</a>
 * @date 10/08/2016
 */
public abstract class CommonEmailVariables {

	// -----------------------------------------------------------------------------------------
	// Common variables
	// -----------------------------------------------------------------------------------------
	/** Reference variable **/
	public static final String REFERENCE = "reference";
	/** Description variable **/
	public static final String DESCRIPTION = "description";
	/** "To" variable **/
	public static final String DESTINATION = "destinatario";
	/** Parameter Reply To */
	public static final String PARAMETER_REPLY_TO = "responderA";
	/** Parameter copy list */
	public static final String PARAMETER_CC = "cc";
	/** Parameter Subject */
	public static final String SUBJECT = "asunto";
	/** Country **/
	public static final String COUNTRY = "country";
	/** currency sign **/
	public static final String CURRENCY_SIGN_EN = "currencySign";
	/** Expiration date **/
	public static final String EXPIRATION_DATE_EN = "expirationDate";
	/** Creation date attribute **/
	public static final String CREATION_DATE = "creationDate";
	/** Payment date attribute **/
	public static final String PAYMENT_DATE = "paymentDate";
	/** Value to avoid the alert generation for the magic number */
	public static final int ZERO = 0;
	/** Indicates the max length of merchant short name */
	public static final int MAX_LENGTH_MERCHANT_SHORT_NAME = 50;
	/** The url var to email */
	public static final String URL_VAR = "url";
	/** Show contact info attribute */
	public static final String SHOW_CONTACT_INFO = "showContactInfo";
	/** Extraparameter installments number */
	public static final String EXTRA_PARAM_INSTALLMENTS_NUMBER_VALUE = "extraParamInstallmentsNumberValue";
	/** Extraparameter url payment receipt html */
	public static final String EXTRA_PARAM_URL_PAYMENT_RECEIPT_HTML = "extraParamUrlPaymentReceiptHtmlValue";
	/** Extraparameter 1 */
	public static final String EXTRA_PARAM1 = "extraParam1";
	/** Extraparameter 2 */
	public static final String EXTRA_PARAM2 = "extraParam2";

	// -----------------------------------------------------------------------------------------
	// Common transaction variables
	// -----------------------------------------------------------------------------------------
	/** Transaction id attribute */
	public static final String TRANSACTION_ID = "transactionId";
	/** Transaction state value **/
	public static final String TRANSACTION_STATE_VALUE = "transactionStateValue";
	/** Transaction last update attribute **/
	public static final String TRANSACTION_LAST_UPDATED_DATE = "transactionLastUpdatedDate";
	/** transaction tx value **/
	public static final String TRANSACTION_TX_VALUE = "transactionTxValue";
	/** Transaction tx value currency **/
	public static final String TRANSACTION_TX_VALUE_CURRENCY = "transactionTxValueCurrency";
	/** Transaction pm network value **/
	public static final String TRANSACTION_PM_NETWORK_VALUE = "transactionPmNetworkValue";
	/** Transaction pm network value currency **/
	public static final String TRANSACTION_PM_NETWORK_VALUE_CURRENCY = "transactionPmNetworkValueCurrency";
	/** Transaction paymen method description **/
	public static final String TRANSACTION_PAYMENT_METHOD_DESCRIPTION = "transactionPaymentMethodDescription";
	/** Transaction payment method value **/
	public static final String TRANSACTION_PAYMENT_METHOD_VALUE = "transactionPaymentMethodValue";
	/** Transaction payment method type **/
	public static final String TRANSACTION_PAYMENT_METHOD_TYPE = "transactionPaymentMethodType";
	/** Transaction credit card masked number **/
	public static final String TRANSACTION_CREDIT_CARD_MASKED_NUMBER = "transactionCreditCardMaskedNumber";

	// -----------------------------------------------------------------------------------------
	// Common order variables
	// -----------------------------------------------------------------------------------------
	/** Transaction order id **/
	public static final String TRANSACTION_ORDER_ID = "transactionOrderId";
	/** Transaction order is test **/
	public static final String TRANSACTION_ORDER_IS_TEST = "transactionOrderIsTest";
	/** Transaction order description **/
	public static final String TRANSACTION_ORDER_DESCRIPTION = "transactionOrderDescription";
	/** Transaction order reference code **/
	public static final String TRANSACTION_ORDER_REFERENCE_CODE = "transactionOrderReferenceCode";
	/** Transaction order account country **/
	public static final String TRANSACTION_ORDER_ACCOUNT_COUNTRY = "transactionOrderAccountCountry";
	/** Transaction order account payments model **/
	public static final String TRANSACTION_ORDER_ACCOUNT_PAYMENTS_MODEL = "transactionOrderAccountPaymentsModel";
	/** Transaction order account web page customer support **/
	public static final String TRANSACTION_ORDER_ACCOUNT_WEB_PAGE_CUSTOMER_SUPPORT = "transactionOrderAccountWebPageCustomerSupport";
	/** transaction order account email address customer support **/
	public static final String TRANSACTION_ORDER_ACCOUNT_EMAIL_ADDRESS_CUSTOMER_SUPPORT = "transactionOrderAccountEmailAddressCustomerSupport";
	/** Transaction order account phone number customer support **/
	public static final String TRANSACTION_ORDER_ACCOUNT_PHONE_NUMBER_CUSTOMER_SUPPORT = "transactionOrderAccountPhoneNumberCustomerSupport";
	/** Transaction order account commercial name **/
	public static final String TRANSACTION_ORDER_ACCOUNT_COMMERCIAL_NAME = "transactionOrderAccountCommercialName";
	/** Transaction order buyer email address **/
	public static final String TRANSACTION_ORDER_BUYER_EMAIL_ADDRESS = "transactionOrderBuyerEmailAddress";
	/** Transaction order buyer full name **/
	public static final String TRANSACTION_ORDER_BUYER_FULL_NAME = "transactionOrderBuyerFullName";
	/** Transaction order shipment full name **/
	public static final String TRANSACTION_ORDER_SHIPMENT_FULL_NAME = "transactionOrderShipmentFullName";
	/** Transaction order merchant url **/
	public static final String TRANSACTION_ORDER_MERCHANT_CONTACT_EMAIL = "transactionOrderMerchantContactEmail";

	// -----------------------------------------------------------------------------------------
	// Common merchant variables
	// -----------------------------------------------------------------------------------------
	/** Transaction merchant type **/
	public static final String TRANSACTION_MERCHANT_TYPE = "transactionMerchantType";
	/** Transaction merchant country **/
	public static final String TRANSACTION_MERCHANT_COUNTRY = "transactionMerchantCountry";
	/** Transaction merchant names **/
	public static final String TRANSACTION_MERCHANT_NAMES = "transactionMerchantNames";
	/** Transaction merchant names **/
	public static final String TRANSACTION_MERCHANT_SURNAMES = "transactionMerchantSurNames";
	/** Transaction merchant url **/
	public static final String TRANSACTION_MERCHANT_URL = "transactionMerchantUrl";
	/** Transaction merchant url **/
	public static final String TRANSACTION_MERCHANT_CONTACT_EMAIL = "transactionMerchantContactEmail";
	/** Merchant name cut **/
	public static final String MERCHANT_NAME_CUT = "merchantNameCut";
	/** Merchant name **/
	public static final String MERCHANT_NAME_EN = "merchantName";
	/** Merchant logo **/
	public static final String MERCHANT_LOGO = "merchantLogo";

	// -----------------------------------------------------------------------------------------
	// Common payer variables
	// -----------------------------------------------------------------------------------------
	/** Transaction payer full name **/
	public static final String TRANSACTION_PAYER_FULL_NAME = "transactionPayerFullName";
	/** The payer phone number parameter for email notification */
	public static final String TRANSACTION_PAYER_PHONE_NUMBER = "payer_phone";
	/** The payer id parameter for email notification */
	public static final String TRANSACTION_PAYER_ID = "payer_id";
	/** The payer id type parameter for email notification */
	public static final String TRANSACTION_PAYER_ID_TYPE = "payer_id_type";
	/** The payer address parameter for email notification */
	public static final String TRANSACTION_PAYER_ADDRESS = "payer_address";

	// -----------------------------------------------------------------------------------------
	// Common payment method variables
	// -----------------------------------------------------------------------------------------
	/** Payment method name **/
	public static final String PAYMENT_METHOD_NAME = "paymentMethodName";
	/** Payment method logo **/
	public static final String PAYMENT_METHOD_LOGO = "paymentMethodLogo";
	/** Payment method logos map **/
	public static final String PAYMENT_METHODS_LOGOS_MAP = "paymentMethodsLogosMap";
	
	// -----------------------------------------------------------------------------------------
	// Common Cash on Delivery variables
	// -----------------------------------------------------------------------------------------
	/** Reference number **/
	public static final String NUM_ORDER = "num_order";
	/** merchant url **/
	public static final String URL_MERCHANT = "url_merchant";
	/** Estimated shipping delivery days **/
	public static final String DELIVERY_DAYS = "delivery_days";
	/** Estimated shipping min delivery days **/
	public static final String MIN_DELIVERY_DAYS = "min_delivery_days";
	/** Delivery address **/
	public static final String DELIVERY_ADDRESS = "shipping_address_delivery";
	/** Delivery country **/
	public static final String DELIVERY_COUNTRY = "delivery_country";
	/** Delivery state **/
	public static final String DELIVERY_STATE = "delivery_state";
	/** Delivery city **/
	public static final String DELIVERY_CITY = "delivery_city";
	/** Delivery Zipcode **/
	public static final String DELIVERY_ZIP_CODE = "delivery_zipcode";
	/** Company url **/
	public static final String DELIVERY_COMPANY_URL = "company_url";
	/** Delivery comments **/
	public static final String DELIVERY_COMMENTS = "delivery_comments";
	/** Shipping purchase value **/
	public static final String SHIPPING_PURCHASE_VALUE = "shipping_purchase_value";
	/** Shipping value **/
	public static final String SHIPPING_VALUE = "shipping_value";
	/** Shipping total value **/
	public static final String SHIPPING_TOTAL_VALUE = "shipping_total_value";
	/** Buyer name **/
	public static final String BUYER_NAME = "buyer_name";
	/** Confirmation url **/
	public static final String CONFIRM_URL = "confirm_url";
	/** Cancel url **/
	public static final String CANCEL_URL = "cancel_url";
	/** Shipment merchant case **/
	public static final String SHIPMENT_MERCHANT_CASE = "shipment_merchant_case";
	/** Cod value **/
	public static final String CASH_ON_DELIVERY_VALUE = "cash_on_delivery_value";
	
	// -----------------------------------------------------------------------------------------
	// Lending variables
	// -----------------------------------------------------------------------------------------
	/** The max payment date without interest */
	public static final String MAX_PAYMENT_DATE_WITHOUT_INTEREST = "max_payment_date_without_interest";
	/** The transaction fee */
	public static final String TRANSACTION_TX_FEE = "transaction_tx_fee";
	/** The transaction value with fee */
	public static final String TRANSACTION_TX_VALUE_WITH_FEE = "transaction_tx_value_with_fee";
	
	// -----------------------------------------------------------------------------------------
	// Payment request variables
	// -----------------------------------------------------------------------------------------
	/**	Total Transaction Value Parameter */
	public static final String PARAMETER_TOTAL_VALUE = "totalValue";
	/** Subtotal Transaction Value Parameter */
	public static final String PARAMETER_SUBTOTAL_VALUE = "subtotalValue";
	/** Tax Transaction Value Parameter */
	public static final String PARAMETER_TAX_VALUE = "taxValue";
	/** Transaction Shipment Value Parameter */
	public static final String PARAMETER_SHIPMENT_VALUE = "shipmentValue";
	/** Transaction Shipment Value Parameter */
	public static final String PARAMETER_TOTAL_WITHOUT_SHIPMENT_VALUE = "totalWithoutShipmentValue";
	/** Merchant Parameter */
	public static final String PARAMETER_MERCHANT = "merchant";
	/** Account Parameter */
	public static final String PARAMETER_ACCOUNT = "account";	
	/** Payment Request Buyer Information Parameter */
	public static final String PARAMETER_REQUEST_BUYER_FULL_NAME = "paymentRequestBuyerFullName";
	/** Payment Request Buyer Information Parameter */
	public static final String PARAMETER_REQUEST_BUYER_EMAIL_ADDRESS = "paymentRequestBuyerEmailAddress";	
	/** Payment Request Parameter Country */
	public static final String PARAMETER_REQUEST_LINK_COUNTRY = "paymentRequestLinkCountry";		
	/** Product List Parameter */
	public static final String PARAMETER_PRODUCTS = "products";
	/** Expiration Date Parameter */
	public static final String PARAMETER_INITIAL_DATE = "initialDate";
	/** Expiration Date Parameter */
	public static final String PARAMETER_EXPIRATION_DATE = "expirationDate";
	/** Link Parameter */
	public static final String PARAMETER_LINK = "link";
	/** Currency format for values */
	public static final String CURRENCY_FORMAT = "###,##0.00";
	/** Number format */
	public static final String NUMBER_FORMAT = "numberFormat";	
	/** Constant used te calculate the order total */
	public static final String TOTAL = "total";
	/** Constant used te calculate the order sub total */
	public static final String SUB_TOTAL = "subtotal";
	/** Constant used te calculate the order tax */
	public static final String IMPUESTOS = "impuestos";
	/** Constant used te calculate the order grand total */
	public static final String GRAN_TOTAL = "grantotal";
	/** Constant of the account comercial name  */
	public static final String ACCOUNT_COMERCIAL_NAME = "accountCommercialName";
	/** Constant of the account phone customer support  */
	public static final String ACCOUNT_PHONE_NUMBER_CUSTOMER_SUPPORT = "accountPhoneNumberCustomerSupport";
	/** Constant of the account email customer support  */
	public static final String ACCOUNT_EMAIL_ADDRESS_CUSTOMER_SUPPORT = "accountEmailAddressCustomerSupport";
	/** Merchant contact email **/
	public static final String MERCHANT_CONTACT_EMAIL = "merchantContactEmail";
	/** Merchant number phone **/
	public static final String MERCHANT_NUMBER_PHONE = "merchantNumberPhone";
	/** Payment Request name */
	public static final String PAYMENT_REQUEST_LINK_NAME = "paymentRequestLinkName";
	/** Payment Request id */
	public static final String PAYMENT_REQUEST_LINK_ID = "paymentRequestLinkRequestId";
	/** Payment Request merchant commentaries */
	public static final String PAYMENT_REQUEST_MERCHANT_COMMENTARIES = "paymentRequestLinkMerchantCommentaries";
	/** Merchant document parameter */
	public static final String PARAMETER_MERCHANT_DOCUMENT = "merchantDocument";
	/** Merchant document type parameter */
	public static final String PARAMETER_MERCHANT_DOCUMENT_TYPE = "merchantDocumentType";
	/** Merchant country description parameter */
	public static final String PARAMETER_MERCHANT_COUNTRY_DESCRIPTION = "merchantCountryDescription";
	/** Merchant Brand */
	public static final String PARAMETER_MERCHANT_BRAND = "merchantBrand";
	/** Merchant Phone Number */
	public static final String PARAMETER_MERCHANT_PHONE_NUMBER = "merchantPhoneNumber";
	/** Merchant Contact Email */
	public static final String PARAMETER_MERCHANT_CONTACT_EMAIL = "merchantContactEmail";
	/** Merchant Contact Logo */
	public static final String PARAMETER_MERCHANT_LOGO = "merchantImage";	
	/** Payment request additional value TX_TAX_RETURN_BASE */
	public static final String ADDITIONAL_VALUE_TX_TAX_RETURN_BASE = "additionalValueTxTaxReturnBase";
	/** Payment request additional value TX_TAX*/
	public static final String ADDITIONAL_VALUE_TX_TAX = "additionalValueTxTax";
	/** Payment request additional value TX_VALUE*/
	public static final String ADDITIONAL_VALUE_TX_VALUE = "additionalValueTxValue";
	
	// -----------------------------------------------------------------------------------------
	// Payment reference variables
	// -----------------------------------------------------------------------------------------
	/** Parameter Methods Section */
	public static final String PARAMETER_METHODS = "methodsReferences";
	/** Parameter email message */
	public static final String PARAMETER_MESSAGE = "message";
	/** Parameter Number */
	public static final String PARAMETER_NUMBER = "number";
	/** Parameter for reminder email */
	public static final String PARAMETER_REMINDER = "reminder";
	/** Parameter Name */
	public static final String PARAMETER_NAME = "name";
	
	// -----------------------------------------------------------------------------------------
	// Payment Card Request variables
	// -----------------------------------------------------------------------------------------
	/** Parameter reference */
	public static final String PARAMETER_REFERENCE = "referencia";
	
	/** The mail parameter PARAMETER_VALUE */
	public static final String PARAMETER_VALUE = "valor";

	/** The mail parameter PARAMETER_CURRENCY */
	public static final String PARAMETER_CURRENCY = "moneda";

	/**  The mail parameter PARAMETER_QUANTITY */
	public static final String PARAMETER_QUANTITY = "cantidad";

	/** The mail parameter PARAMETER_ADDRESS_1 */
	public static final String PARAMETER_ADDRESS_1 = "direccion1";

	/**  The mail parameter PARAMETER_ADDRESS_2 */
	public static final String PARAMETER_ADDRESS_2 = "direccion2";

	/** The mail parameter PARAMETER_POSTAL_CODE */
	public static final String PARAMETER_POSTAL_CODE = "postalCode";
	
	/** The mail parameter company url */
	public static final String PARAMETER_COMPANY_URL = "companyUrl";
	
	/** The mail parameter guide number url */
	public static final String PARAMETER_GUIDE_NUMBER = "guideNumber";
	
	// -----------------------------------------------------------------------------------------
	// PayU Click
	// -----------------------------------------------------------------------------------------
	/** The mandrill email to param */
	public static final String EMAIL_TO_PARAM = "EmailTo";
	
	/** The mandrill payer name param */
	public static final String EMAIL_PAYER_NAME_PARAM = "payer_name";
	
	/** The mandrill credit card type param */
	public static final String EMAIL_CREDIT_CARD_TYPE_PARAM = "credit_card_type";
	
	/** The mandrill credit card number param */
	public static final String EMAIL_CREDIT_CARD_NUMBER_PARAM = "credit_card_number";
	
	/** The mandrill browser name param */
	public static final String EMAIL_BROWSER_PARAM = "browser_name";
	
	/** The mandrill operative system name param */
	public static final String EMAIL_OPERATIVE_SYSTEM_PARAM = "os_name";
	
	/** The expiration_time param in email template CREDIT_CARD_ELIMINATION_PAYU_CLICK**/
	public static final String EXPIRATION_TIME_PARAM = "expiration_time";

	/** The cancel_url param in email template CREDIT_CARD_ELIMINATION_PAYU_CLICK**/
	public static final String CANCEL_URL_PARAM = "cancel_url";
	
	// -----------------------------------------------------------------------------------------
	// Spei Transaction Email
	// -----------------------------------------------------------------------------------------
	/** The predefined merchant friendly name */
	public static final String FANTASY_NAME = "fantasyMerchantName";

	/** The bank name to receive the payment */
	public static final String BANK_NAME = "bankName";

	/** The inter-bank code */
	public static final String CLABE = "clabe";

	/** The transaction expiration date */
	public static final String EXPIRATION_TIME = "expirationTime";

	/** The url to checkout */
	public static final String EXTRA_PARAM_URL_PAYMENT_RECEIPT_PDF = "extraParamUrlPaymentReceiptPdfValue";
	
	/** The tx administrative fee variable. */ 
	public static final String TX_ADMINISTRATIVE_FEE = "txAdministrativeFee";
	
	/** The tx additional value variable. */
	public static final String TX_ADDITIONAL_VALUE = "txAdditionalValue";
	
	/**
	 * Private Constructor to disable instantiation
	 */
	private CommonEmailVariables() {

	}
	
}