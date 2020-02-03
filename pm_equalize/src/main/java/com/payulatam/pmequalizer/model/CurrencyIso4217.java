package com.payulatam.pmequalizer.model;

public enum CurrencyIso4217 {

	/**
	 * Argentine Peso.
	 */
	ARS("$", "032", true),

	/**
	 * Brazilian Real.
	 */
	BRL("Reais", "R$", "986", true) {
		@Override
		public String getComposeDescription() {

			return getSign();
		}
	},

	/**
	 * Canadian Dolar.
	 */
	CAD("$", "124", true),

	/**
	 * Colombian Peso.
	 */
	COP("$", "170", false),

	/**
	 * Chilean Peso.
	 */
	CLP("$", "152", false),

	/**
	 * Euro.
	 */
	EUR("€", "978", true),

	/**
	 * Mexican Peso.
	 */
	MXN("$", "484", true),

	/**
	 * Nuevo Sol.
	 */
	PEN("S/.", "604", true),

	/**
	 * Guarani.
	 */
	PYG("$", "600", true),

	/**
	 * US Dollar.
	 */
	USD("$", "840", true),

	/**
	 * Afghani.
	 */
	AFN("$", "971", true),

	/**
	 * Lek.
	 */
	ALL("$", "008", true),

	/**
	 * Algerian Dinar.
	 */
	DZD("$", "012", true),

	/**
	 * Kwanza.
	 */
	AOA("$", "973", true),

	/**
	 * East Caribbean Dollar.
	 */
	XCD("$", "951", true),

	/**
	 * Armenian Dram.
	 */
	AMD("$", "051", true),

	/**
	 * Aruban Guilder.
	 */
	AWG("ƒ", "533", true),

	/**
	 * Australian Dollar.
	 */
	AUD("$", "036", true),

	/**
	 * Azerbaijanian Manat.
	 */
	AZN("$", "944", true),

	/**
	 * Bahamian Dollar.
	 */
	BSD("$", "044", true),

	/**
	 * Bahraini Dinar.
	 */
	BHD("$", "048", true),

	/**
	 * Taka.
	 */
	BDT("$", "050", true),

	/**
	 * Barbados Dollar.
	 */
	BBD("$", "052", true),

	/**
	 * Belarussian Ruble.
	 */
	BYR("$", "974", true),

	/**
	 * Belize Dollar.
	 */
	BZD("$", "084", true),

	/**
	 * CFA Franc BCEAO.
	 */
	XOF("$", "952", true),

	/**
	 * Bermudian Dollar.
	 */
	BMD("$", "060", true),

	/**
	 * Indian Rupee.
	 */
	INR("$", "356", true),

	/**
	 * Ngultrum.
	 */
	BTN("$", "064", true),

	/**
	 * Boliviano.
	 */
	BOB("$", "068", true),

	/**
	 * Mvdol .
	 */
	BOV("$", "984", true),

	/**
	 * Convertible Mark.
	 */
	BAM("$", "977", true),

	/**
	 * Pula.
	 */
	BWP("$", "072", true),

	/**
	 * Norwegian Krone.
	 */
	NOK("$", "578", true),

	/**
	 * Brunei Dollar.
	 */
	BND("$", "096", true),

	/**
	 * Bulgarian Lev.
	 */
	BGN("$", "975", true),

	/**
	 * Burundi Franc.
	 */
	BIF("$", "108", true),

	/**
	 * Riel.
	 */
	KHR("$", "116", true),

	/**
	 * CFA Franc BEAC?.
	 */
	XAF("$", "950", true),

	/**
	 * Cape Verde Escudo.
	 */
	CVE("$", "132", true),

	/**
	 * Cayman Islands Dollar.
	 */
	KYD("$", "136", true),

	/**
	 * Unidades de fomento.
	 */
	CLF("$", "990", true),

	/**
	 * Yuan Renminbi.
	 */
	CNY("$", "156", true),

	/**
	 * Unidad de Valor Real .
	 */
	COU("$", "970", true),

	/**
	 * Comoro Franc.
	 */
	KMF("$", "174", true),

	/**
	 * Congolese Franc .
	 */
	CDF("$", "976", true),

	/**
	 * New Zealand Dollar.
	 */
	NZD("$", "554", true),

	/**
	 * Costa Rican Colon.
	 */
	CRC("₡", "188", true),

	/**
	 * Croatian Kuna.
	 */
	HRK("$", "191", true),

	/**
	 * Cuban Peso.
	 */
	CUP("$", "192", true),

	/**
	 * Peso Convertible .
	 */
	CUC("$", "931", true),

	/**
	 * Netherlands Antillean Guilder.
	 */
	ANG("ƒ", "532", true),

	/**
	 * Czech Koruna.
	 */
	CZK("$", "203", true),

	/**
	 * Danish Krone.
	 */
	DKK("$", "208", true),

	/**
	 * Djibouti Franc.
	 */
	DJF("$", "262", true),

	/**
	 * Dominican Peso.
	 */
	DOP("RD$", "214", true),

	/**
	 * Egyptian Pound.
	 */
	EGP("$", "818", true),

	/**
	 * El Salvador Colon.
	 */
	SVC("$", "222", true),

	/**
	 * Nakfa.
	 */
	ERN("$", "232", true),

	/**
	 * Ethiopian Birr.
	 */
	ETB("$", "230", true),

	/**
	 * Falkland Islands Pound.
	 */
	FKP("$", "238", true),

	/**
	 * Fiji Dollar.
	 */
	FJD("$", "242", true),

	/**
	 * CFP Franc.
	 */
	XPF("$", "953", true),

	/**
	 * Dalasi.
	 */
	GMD("$", "270", true),

	/**
	 * Lari.
	 */
	GEL("$", "981", true),

	/**
	 * Cedi.
	 */
	GHS("$", "936", true),

	/**
	 * Gibraltar Pound.
	 */
	GIP("$", "292", true),

	/**
	 * Quetzal.
	 */
	GTQ("$", "320", true),

	/**
	 * Pound Sterling.
	 */
	GBP("£", "826", true),

	/**
	 * Guinea Franc.
	 */
	GNF("$", "324", true),

	/**
	 * Guyana Dollar.
	 */
	GYD("$", "328", true),

	/**
	 * Gourde.
	 */
	HTG("$", "332", true),

	/**
	 * Lempira.
	 */
	HNL("$", "340", true),

	/**
	 * Hong Kong Dollar.
	 */
	HKD("$", "344", true),

	/**
	 * Forint.
	 */
	HUF("$", "348", true),

	/**
	 * Iceland Krona.
	 */
	ISK("$", "352", true),

	/**
	 * Rupiah.
	 */
	IDR("$", "360", true),

	/**
	 * SDR (Special Drawing Right).
	 */
	XDR("$", "960", true),

	/**
	 * Iranian Rial.
	 */
	IRR("$", "364", true),

	/**
	 * Iraqi Dinar.
	 */
	IQD("$", "368", true),

	/**
	 * New Israeli Sheqel.
	 */
	ILS("$", "376", true),

	/**
	 * Jamaican Dollar.
	 */
	JMD("$", "388", true),

	/**
	 * Yen.
	 */
	JPY("$", "392", true),

	/**
	 * Jordanian Dinar.
	 */
	JOD("$", "400", true),

	/**
	 * Tenge.
	 */
	KZT("$", "398", true),

	/**
	 * Kenyan Shilling.
	 */
	KES("$", "404", true),

	/**
	 * North Korean Won.
	 */
	KPW("$", "408", true),

	/**
	 * Won.
	 */
	KRW("$", "410", true),

	/**
	 * Kuwaiti Dinar.
	 */
	KWD("$", "414", true),

	/**
	 * Som.
	 */
	KGS("$", "417", true),

	/**
	 * Kip.
	 */
	LAK("$", "418", true),

	/**
	 * Latvian Lats.
	 */
	LVL("$", "428", true),

	/**
	 * Lebanese Pound.
	 */
	LBP("$", "422", true),

	/**
	 * Loti.
	 */
	LSL("$", "426", true),

	/**
	 * Liberian Dollar.
	 */
	LRD("$", "430", true),

	/**
	 * Libyan Dinar.
	 */
	LYD("$", "434", true),

	/**
	 * Swiss Franc.
	 */
	CHF("$", "756", true),

	/**
	 * Lithuanian Litas.
	 */
	LTL("$", "440", true),

	/**
	 * Pataca.
	 */
	MOP("$", "446", true),

	/**
	 * Denar.
	 */
	MKD("$", "807", true),

	/**
	 * Malagasy Ariary.
	 */
	MGA("$", "969", true),

	/**
	 * Kwacha.
	 */
	MWK("$", "454", true),

	/**
	 * Malaysian Ringgit.
	 */
	MYR("$", "458", true),

	/**
	 * Rufiyaa.
	 */
	MVR("$", "462", true),

	/**
	 * Ouguiya.
	 */
	MRO("$", "478", true),

	/**
	 * Mauritius Rupee.
	 */
	MUR("$", "480", true),

	/**
	 * ADB Unit of Account.
	 */
	XUA("$", "965", true),

	/**
	 * Mexican Unidad de Inversion (UDI) .
	 */
	MXV("$", "979", true),

	/**
	 * Moldovan Leu.
	 */
	MDL("$", "498", true),

	/**
	 * Tugrik.
	 */
	MNT("$", "496", true),

	/**
	 * Moroccan Dirham.
	 */
	MAD("$", "504", true),

	/**
	 * Metical.
	 */
	MZN("$", "943", true),

	/**
	 * Kyat.
	 */
	MMK("$", "104", true),

	/**
	 * Namibia Dollar.
	 */
	NAD("$", "516", true),

	/**
	 * South African Rand.
	 */
	ZAR("$", "710", true),

	/**
	 * Nepalese Rupee.
	 */
	NPR("$", "524", true),

	/**
	 * Cordoba Oro.
	 */
	NIO("$", "558", true),

	/**
	 * Naira.
	 */
	NGN("$", "566", true),

	/**
	 * Rial Omani.
	 */
	OMR("$", "512", true),

	/**
	 * Pakistan Rupee.
	 */
	PKR("$", "586", true),

	/**
	 * Balboa.
	 */
	PAB("B/.", "590", true),

	/**
	 * Kina.
	 */
	PGK("$", "598", true),

	/**
	 * Philippine Peso.
	 */
	PHP("$", "608", true),

	/**
	 * Zloty.
	 */
	PLN("$", "985", true),

	/**
	 * Qatari Rial.
	 */
	QAR("$", "634", true),

	/**
	 * Leu .
	 */
	RON("$", "946", true),

	/**
	 * Russian Ruble.
	 */
	RUB("$", "643", true),

	/**
	 * Rwanda Franc.
	 */
	RWF("$", "646", true),

	/**
	 * Saint Helena Pound.
	 */
	SHP("$", "654", true),

	/**
	 * Tala.
	 */
	WST("$", "882", true),

	/**
	 * Dobra.
	 */
	STD("$", "678", true),

	/**
	 * Saudi Riyal.
	 */
	SAR("$", "682", true),

	/**
	 * Serbian Dinar.
	 */
	RSD("$", "941", true),

	/**
	 * Seychelles Rupee.
	 */
	SCR("$", "690", true),

	/**
	 * Leone.
	 */
	SLL("$", "694", true),

	/**
	 * Singapore Dollar.
	 */
	SGD("$", "702", true),

	/**
	 * Sucre.
	 */
	XSU("$", "994", true),

	/**
	 * Solomon Islands Dollar.
	 */
	SBD("$", "090", true),

	/**
	 * Somali Shilling.
	 */
	SOS("$", "706", true),

	/**
	 * Sri Lanka Rupee.
	 */
	LKR("$", "144", true),

	/**
	 * Sudanese Pound .
	 */
	SDG("$", "938", true),

	/**
	 * Surinam Dollar.
	 */
	SRD("$", "968", true),

	/**
	 * Lilangeni.
	 */
	SZL("$", "748", true),

	/**
	 * Swedish Krona.
	 */
	SEK("$", "752", true),

	/**
	 * WIR Euro .
	 */
	CHE("$", "947", true),

	/**
	 * WIR Franc .
	 */
	CHW("$", "948", true),

	/**
	 * Syrian Pound.
	 */
	SYP("$", "760", true),

	/**
	 * New Taiwan Dollar.
	 */
	TWD("$", "901", true),

	/**
	 * Somoni .
	 */
	TJS("$", "972", true),

	/**
	 * Tanzanian Shilling.
	 */
	TZS("$", "834", true),

	/**
	 * Baht.
	 */
	THB("$", "764", true),

	/**
	 * Pa'anga.
	 */
	TOP("$", "776", true),

	/**
	 * Trinidad and Tobago Dollar.
	 */
	TTD("$", "780", true),

	/**
	 * Tunisian Dinar.
	 */
	TND("$", "788", true),

	/**
	 * Turkish Lira .
	 */
	TRY("$", "949", true),

	/**
	 * New Manat.
	 */
	TMT("$", "934", true),

	/**
	 * Uganda Shilling.
	 */
	UGX("$", "800", true),

	/**
	 * Hryvnia.
	 */
	UAH("$", "980", true),

	/**
	 * UAE Dirham.
	 */
	AED("$", "784", true),

	/**
	 * US Dollar (Next day).
	 */
	USN("$", "997", true),

	/**
	 * US Dollar (Same day).
	 */
	USS("$", "998", true),

	/**
	 * Peso Uruguayo.
	 */
	UYU("$", "858", true),

	/**
	 * Uruguay Peso en Unidades Indexadas (URUIURUI) .
	 */
	UYI("$", "940", true),

	/**
	 * Uzbekistan Sum.
	 */
	UZS("$", "860", true),

	/**
	 * Vatu.
	 */
	VUV("$", "548", true),

	/**
	 * Bolivar Fuerte .
	 */
	VEF("Bs", "937", true),

	/**
	 * Dong.
	 */
	VND("$", "704", true),

	/**
	 * Yemeni Rial.
	 */
	YER("$", "886", true),

	/**
	 * Zambian Kwacha.
	 */
	ZMK("$", "894", true),

	/**
	 * Zimbabwe Dollar .
	 */
	ZWL("$", "932", true),

	/**
	 * Bond Markets Unit European Composite Unit (EURCO).
	 */
	XBA("$", "955", true),

	/**
	 * Bond Markets Unit European Monetary Unit (E.M.U.-6).
	 */
	XBB("$", "956", true),

	/**
	 * Bond Markets Unit European Unit of Account 9 (E.U.A.-9).
	 */
	XBC("$", "957", true),

	/**
	 * Bond Markets Unit European Unit of Account 17 (E.U.A.-17).
	 */
	XBD("$", "958", true),

	/**
	 * UIC-Franc.
	 */
	XFU("$", "Nil", true),

	/**
	 * Codes specifically reserved for testing purposes.
	 */
	XTS("$", "963", true),

	/**
	 * The codes assigned for transactions where no currency is involved.
	 */
	XXX("$", "999", true),

	/**
	 * Gold.
	 */
	XAU("$", "959", true),

	/**
	 * Palladium.
	 */
	XPD("$", "964", true),

	/**
	 * Platinum.
	 */
	XPT("$", "962", true),

	/**
	 * Silver.
	 */
	XAG("$", "961", true);

	/**
	 * The currency local name.
	 */
	private final String description;

	/**
	 * The currency sign.
	 */
	private final String sign;

	/**
	 * The currency code.
	 */
	private final String code;

	/**
	 * Specifies if the currency accepts decimals
	 */
	private final boolean decimalValuesAccepted;

	CurrencyIso4217(final String sign, final String code, final boolean decimalValuesAccepted) {
		this.sign = sign;
		this.code = code;
		this.decimalValuesAccepted = decimalValuesAccepted;
		description = name();
	}

	CurrencyIso4217(final String description, final String sign, final String code,
	                final boolean decimalValuesAccepted) {
		this.sign = sign;
		this.code = code;
		this.decimalValuesAccepted = decimalValuesAccepted;
		this.description = description;
	}

	/**
	 * Gets the sign.
	 *
	 * @return the sign
	 */
	public String getSign() {

		return sign;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {

		return code;
	}

	/**
	 * Returns <code>true</code> if the currency supports/accepts decimal values.
	 * <code>false</code> otherwhise
	 *
	 * @return true if the currency accepts decimal values
	 */
	public boolean isDecimalValuesAccepted() {

		return decimalValuesAccepted;
	}

	/**
	 * Gets the currency description.
	 *
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * Gets the currency compose description <br>
	 * name + sign</br>
	 * .
	 *
	 * @return the description
	 */
	public String getComposeDescription() {

		return description + " " + sign;
	}

	/**
	 * <p>
	 * Return a Currency Object from the String.<br>
	 * Ex. CurrencyIso4217.fromString("cop") return CurrencyIso4217.COP<br>
	 * Ex. CurrencyIso4217.fromString("COP") return CurrencyIso4217.COP<br>
	 * Ex. CurrencyIso4217.fromString("XX") return null<br>
	 * </p>
	 *
	 * @param isoCode4217 The currency iso code 4217
	 * @return The currency object.
	 */
	public static CurrencyIso4217 fromString(final String isoCode4217) {

		if (isoCode4217 != null) {
			for (final CurrencyIso4217 currency : CurrencyIso4217.values()) {
				if (isoCode4217.equalsIgnoreCase(currency.toString())) {
					return currency;
				}
			}
		}
		return null;
	}
}