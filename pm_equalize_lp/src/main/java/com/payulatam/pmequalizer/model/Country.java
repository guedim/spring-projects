package com.payulatam.pmequalizer.model;

public enum Country {

	/**
	 * Argentina Country.
	 */
	AR("ARGENTINA", "AR", "ARG", CurrencyIso4217.ARS, LanguageIso639.es, "GMT-03"),

	/**
	 * Brazil Country
	 */
	BR("BRASIL", "BR", "BRA", CurrencyIso4217.BRL, LanguageIso639.pt, "GMT-02"),

	/**
	 * Canada Country
	 */
	CA("CANADA", "CA", "CAN", CurrencyIso4217.CAD, LanguageIso639.en, null),

	/**
	 * Chile Country.
	 */
	CL("CHILE", "CL", "CHL", CurrencyIso4217.CLP, LanguageIso639.es, "GMT-03"),

	/**
	 * Colombia Country
	 */
	CO("COLOMBIA", "CO", "COL", CurrencyIso4217.COP, LanguageIso639.es, "GMT-05"),

	/**
	 * France Country.
	 */
	FR("FRANCIA", "FR", "FRA", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Germany Country
	 */
	DE("ALEMANIA", "DE", "DEU", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Greece Country
	 */
	GR("GRECIA", "GR", "GRC", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Italy Country
	 */
	IT("ITALIA", "IT", "ITA", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Mexico Country.
	 */
	MX("MÉXICO", "MX", "MEX", CurrencyIso4217.MXN, LanguageIso639.es, "GMT-06"),

	/**
	 * Panama Country.
	 */
	PA("PANAMÁ", "PA", "PAN", CurrencyIso4217.USD, LanguageIso639.es, "GMT-05"),

	/**
	 * Paraguay Country.
	 */
	PY("PARAGUAY", "PY", "PRY", CurrencyIso4217.PYG, LanguageIso639.es, null),

	/**
	 * Peru Country.
	 */
	PE("PERÚ", "PE", "PER", CurrencyIso4217.PEN, LanguageIso639.es, "GMT-05"),

	/**
	 * Portugal Country.
	 */
	PT("PORTUGAL", "PT", "PRT", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Spaing Country.
	 */
	ES("ESPAÑA", "ES", "ESP", CurrencyIso4217.EUR, LanguageIso639.es, null),

	/**
	 * United Kingdom Country.
	 */
	GB("UNITED KINGDOM", "GB", "GBR", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * United States Country
	 */
	US("UNITED STATES", "US", "USA", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Afghanistan Country.
	 */
	AF("AFGHANISTAN", "AF", "AFG", CurrencyIso4217.AFN, LanguageIso639.en, null),

	/**
	 * Åland islands Country.
	 */
	AX("ÅLAND ISLANDS", "AX", "ALA", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Albania Country.
	 */
	AL("ALBANIA", "AL", "ALB", CurrencyIso4217.ALL, LanguageIso639.en, null),

	/**
	 * Algeria Country.
	 */
	DZ("ALGERIA", "DZ", "DZA", CurrencyIso4217.DZD, LanguageIso639.en, null),

	/**
	 * American samoa Country.
	 */
	AS("AMERICAN SAMOA", "AS", "ASM", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Andorra Country.
	 */
	AD("ANDORRA", "AD", "AND", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Angola Country.
	 */
	AO("ANGOLA", "AO", "AGO", CurrencyIso4217.AOA, LanguageIso639.en, null),

	/**
	 * Anguilla Country.
	 */
	AI("ANGUILLA", "AI", "AIA", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Antarctica Country.
	 */
	AQ("ANTARCTICA", "AQ", "ATA", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Antigua and barbuda Country.
	 */
	AG("ANTIGUA AND BARBUDA", "AG", "ATG", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Armenia Country.
	 */
	AM("ARMENIA", "AM", "ARM", CurrencyIso4217.AMD, LanguageIso639.en, null),

	/**
	 * Aruba Country.
	 */
	AW("ARUBA", "AW", "ABW", CurrencyIso4217.AWG, LanguageIso639.en, null),

	/**
	 * Australia Country.
	 */
	AU("AUSTRALIA", "AU", "AUS", CurrencyIso4217.AUD, LanguageIso639.en, null),

	/**
	 * Austria Country.
	 */
	AT("AUSTRIA", "AT", "AUT", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Azerbaijan Country.
	 */
	AZ("AZERBAIJAN", "AZ", "AZE", CurrencyIso4217.AZN, LanguageIso639.en, null),

	/**
	 * Bahamas Country.
	 */
	BS("BAHAMAS", "BS", "BHS", CurrencyIso4217.BSD, LanguageIso639.en, null),

	/**
	 * Bahrain Country.
	 */
	BH("BAHRAIN", "BH", "BHR", CurrencyIso4217.BHD, LanguageIso639.en, null),

	/**
	 * Bangladesh Country.
	 */
	BD("BANGLADESH", "BD", "BGD", CurrencyIso4217.BDT, LanguageIso639.en, null),

	/**
	 * Barbados Country.
	 */
	BB("BARBADOS", "BB", "BRB", CurrencyIso4217.BBD, LanguageIso639.en, null),

	/**
	 * Belarus Country.
	 */
	BY("BELARUS", "BY", "BLR", CurrencyIso4217.BYR, LanguageIso639.en, null),

	/**
	 * Belgium Country.
	 */
	BE("BELGIUM", "BE", "BEL", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Belize Country.
	 */
	BZ("BELIZE", "BZ", "BLZ", CurrencyIso4217.BZD, LanguageIso639.en, null),

	/**
	 * Benin Country.
	 */
	BJ("BENIN", "BJ", "BEN", CurrencyIso4217.XOF, LanguageIso639.en, null),

	/**
	 * Bermuda Country.
	 */
	BM("BERMUDA", "BM", "BMU", CurrencyIso4217.BMD, LanguageIso639.en, null),

	/**
	 * Bhutan Country.
	 */
	BT("BHUTAN", "BT", "BTN", CurrencyIso4217.INR, LanguageIso639.en, null),

	/**
	 * Bolivia, plurinational state of Country.
	 */
	BO("BOLIVIA, PLURINATIONAL STATE OF", "BO", "BOL", CurrencyIso4217.BOB, LanguageIso639.en, null),

	/**
	 * Bonaire, sint eustatius and saba Country.
	 */
	BQ("BONAIRE, SINT EUSTATIUS AND SABA", "BQ", "BES", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Bosnia and herzegovina Country.
	 */
	BA("BOSNIA AND HERZEGOVINA", "BA", "BIH", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Botswana Country.
	 */
	BW("BOTSWANA", "BW", "BWA", CurrencyIso4217.BWP, LanguageIso639.en, null),

	/**
	 * Bouvet island Country.
	 */
	BV("BOUVET ISLAND", "BV", "BVT", CurrencyIso4217.NOK, LanguageIso639.en, null),

	/**
	 * British indian ocean territory Country.
	 */
	IO("BRITISH INDIAN OCEAN TERRITORY", "IO", "IOT", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Brunei darussalam Country.
	 */
	BN("BRUNEI DARUSSALAM", "BN", "BRN", CurrencyIso4217.BND, LanguageIso639.en, null),

	/**
	 * Bulgaria Country.
	 */
	BG("BULGARIA", "BG", "BGR", CurrencyIso4217.BGN, LanguageIso639.en, null),

	/**
	 * Burkina faso Country.
	 */
	BF("BURKINA FASO", "BF", "BFA", CurrencyIso4217.XOF, LanguageIso639.en, null),

	/**
	 * Burundi Country.
	 */
	BI("BURUNDI", "BI", "BDI", CurrencyIso4217.BIF, LanguageIso639.en, null),

	/**
	 * Cambodia Country.
	 */
	KH("CAMBODIA", "KH", "KHM", CurrencyIso4217.KHR, LanguageIso639.en, null),

	/**
	 * Cameroon Country.
	 */
	CM("CAMEROON", "CM", "CRM", CurrencyIso4217.XAF, LanguageIso639.en, null),

	/**
	 * Cape verde Country.
	 */
	CV("CAPE VERDE", "CV", "CPV", CurrencyIso4217.CVE, LanguageIso639.en, null),

	/**
	 * Cayman islands Country.
	 */
	KY("CAYMAN ISLANDS", "KY", "CYM", CurrencyIso4217.KYD, LanguageIso639.en, null),

	/**
	 * Central african republic Country.
	 */
	CF("CENTRAL AFRICAN REPUBLIC", "CF", "CAF", CurrencyIso4217.XAF, LanguageIso639.en, null),

	/**
	 * Chad Country.
	 */
	TD("CHAD", "TD", "TCD", CurrencyIso4217.XAF, LanguageIso639.en, null),

	/**
	 * China Country.
	 */
	CN("CHINA", "CN", "CHN", CurrencyIso4217.CNY, LanguageIso639.en, null),

	/**
	 * Christmas island Country.
	 */
	CX("CHRISTMAS ISLAND", "CX", "CXR", CurrencyIso4217.AUD, LanguageIso639.en, null),

	/**
	 * Cocos (keeling) islands Country.
	 */
	CC("COCOS (KEELING) ISLANDS", "CC", "CCK", CurrencyIso4217.AUD, LanguageIso639.en, null),

	/**
	 * Comoros Country.
	 */
	KM("COMOROS", "KM", "COM", CurrencyIso4217.KMF, LanguageIso639.en, null),

	/**
	 * Congo Country.
	 */
	CG("CONGO", "CG", "COG", CurrencyIso4217.XAF, LanguageIso639.en, null),

	/**
	 * Congo, the democratic republic of the Country.
	 */
	CD("CONGO, THE DEMOCRATIC REPUBLIC OF THE", "CD", "COD", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Cook islands Country.
	 */
	CK("COOK ISLANDS", "CK", "COK", CurrencyIso4217.NZD, LanguageIso639.en, null),

	/**
	 * Costa rica Country.
	 */
	CR("COSTA RICA", "CR", "CRI", CurrencyIso4217.CRC, LanguageIso639.en, null),

	/**
	 * Côte d'ivoire Country.
	 */
	CI("CÔTE D'IVOIRE", "CI", "CIV", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Croatia Country.
	 */
	HR("CROATIA", "HR", "HRV", CurrencyIso4217.HRK, LanguageIso639.en, null),

	/**
	 * Cuba Country.
	 */
	CU("CUBA", "CU", "CUB", CurrencyIso4217.CUP, LanguageIso639.en, null),

	/**
	 * Curacao Country.
	 */
	CW("CURACAO", "CW", "CUW", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Cyprus Country.
	 */
	CY("CYPRUS", "CY", "CYP", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Czech republic Country.
	 */
	CZ("CZECH REPUBLIC", "CZ", "CZE", CurrencyIso4217.CZK, LanguageIso639.en, null),

	/**
	 * Denmark Country.
	 */
	DK("DENMARK", "DK", "DNK", CurrencyIso4217.DKK, LanguageIso639.en, null),

	/**
	 * Djibouti Country.
	 */
	DJ("DJIBOUTI", "DJ", "DJI", CurrencyIso4217.DJF, LanguageIso639.en, null),

	/**
	 * Dominica Country.
	 */
	DM("DOMINICA", "DM", "DMA", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Dominican republic Country.
	 */
	DO("DOMINICAN REPUBLIC", "DO", "DOM", CurrencyIso4217.DOP, LanguageIso639.en, null),

	/**
	 * Ecuador Country.
	 */
	EC("ECUADOR", "EC", "ECU", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Egypt Country.
	 */
	EG("EGYPT", "EG", "EGY", CurrencyIso4217.EGP, LanguageIso639.en, null),

	/**
	 * El salvador Country.
	 */
	SV("EL SALVADOR", "SV", "SLV", CurrencyIso4217.SVC, LanguageIso639.en, null),

	/**
	 * Equatorial guinea Country.
	 */
	GQ("EQUATORIAL GUINEA", "GQ", "GNQ", CurrencyIso4217.XAF, LanguageIso639.en, null),

	/**
	 * Eritrea Country.
	 */
	ER("ERITREA", "ER", "ERI", CurrencyIso4217.ERN, LanguageIso639.en, null),

	/**
	 * Estonia Country.
	 */
	EE("ESTONIA", "EE", "EST", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Ethiopia Country.
	 */
	ET("ETHIOPIA", "ET", "ETH", CurrencyIso4217.ETB, LanguageIso639.en, null),

	/**
	 * Falkland islands (malvinas) Country.
	 */
	FK("FALKLAND ISLANDS (MALVINAS)", "FK", "FLK", CurrencyIso4217.FKP, LanguageIso639.en, null),

	/**
	 * Faroe islands Country.
	 */
	FO("FAROE ISLANDS", "FO", "FRO", CurrencyIso4217.DKK, LanguageIso639.en, null),

	/**
	 * Fiji Country.
	 */
	FJ("FIJI", "FJ", "FJI", CurrencyIso4217.FJD, LanguageIso639.en, null),

	/**
	 * Finland Country.
	 */
	FI("FINLAND", "FI", "FIN", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * French guiana Country.
	 */
	GF("FRENCH GUIANA", "GF", "GUF", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * French polynesia Country.
	 */
	PF("FRENCH POLYNESIA", "PF", "PYF", CurrencyIso4217.XPF, LanguageIso639.en, null),

	/**
	 * French southern territories Country.
	 */
	TF("FRENCH SOUTHERN TERRITORIES", "TF", "ATF", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Gabon Country.
	 */
	GA("GABON", "GA", "GAB", CurrencyIso4217.XAF, LanguageIso639.en, null),

	/**
	 * Gambia Country.
	 */
	GM("GAMBIA", "GM", "GMB", CurrencyIso4217.GMD, LanguageIso639.en, null),

	/**
	 * Georgia Country.
	 */
	GE("GEORGIA", "GE", "GEO", CurrencyIso4217.GEL, LanguageIso639.en, null),

	/**
	 * Ghana Country.
	 */
	GH("GHANA", "GH", "GHA", CurrencyIso4217.GHS, LanguageIso639.en, null),

	/**
	 * Gibraltar Country.
	 */
	GI("GIBRALTAR", "GI", "GIB", CurrencyIso4217.GIP, LanguageIso639.en, null),

	/**
	 * Greenland Country.
	 */
	GL("GREENLAND", "GL", "GRL", CurrencyIso4217.DKK, LanguageIso639.en, null),

	/**
	 * Grenada Country.
	 */
	GD("GRENADA", "GD", "GRD", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Guadeloupe Country.
	 */
	GP("GUADELOUPE", "GP", "GLP", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Guam Country.
	 */
	GU("GUAM", "GU", "GUM", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Guatemala Country.
	 */
	GT("GUATEMALA", "GT", "GTM", CurrencyIso4217.GTQ, LanguageIso639.en, null),

	/**
	 * Guernsey Country.
	 */
	GG("GUERNSEY", "GG", "GGY", CurrencyIso4217.GBP, LanguageIso639.en, null),

	/**
	 * Guinea Country.
	 */
	GN("GUINEA", "GN", "GIN", CurrencyIso4217.XAF, LanguageIso639.en, null),

	/**
	 * Guinea-bissau Country.
	 */
	GW("GUINEA-BISSAU", "GW", "GNB", CurrencyIso4217.XOF, LanguageIso639.en, null),

	/**
	 * Guyana Country.
	 */
	GY("GUYANA", "GY", "GUY", CurrencyIso4217.GYD, LanguageIso639.en, null),

	/**
	 * Haiti Country.
	 */
	HT("HAITI", "HT", "HTI", CurrencyIso4217.HTG, LanguageIso639.en, null),

	/**
	 * Heard island and mcdonald islands Country.
	 */
	HM("HEARD ISLAND AND MCDONALD ISLANDS", "HM", "HMD", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Holy see (vatican city state) Country.
	 */
	VA("HOLY SEE (VATICAN CITY STATE)", "VA", "VAT", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Honduras Country.
	 */
	HN("HONDURAS", "HN", "HND", CurrencyIso4217.HNL, LanguageIso639.en, null),

	/**
	 * Hong kong Country.
	 */
	HK("HONG KONG", "HK", "HKG", CurrencyIso4217.HKD, LanguageIso639.en, null),

	/**
	 * Hungary Country.
	 */
	HU("HUNGARY", "HU", "HUN", CurrencyIso4217.HUF, LanguageIso639.en, null),

	/**
	 * Iceland Country.
	 */
	IS("ICELAND", "IS", "ISL", CurrencyIso4217.ISK, LanguageIso639.en, null),

	/**
	 * India Country.
	 */
	IN("INDIA", "IN", "IND", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Indonesia Country.
	 */
	ID("INDONESIA", "ID", "IDN", CurrencyIso4217.IDR, LanguageIso639.en, null),

	/**
	 * Iran, islamic republic of Country.
	 */
	IR("IRAN, ISLAMIC REPUBLIC OF", "IR", "IRN", CurrencyIso4217.IRR, LanguageIso639.en, null),

	/**
	 * Iraq Country.
	 */
	IQ("IRAQ", "IQ", "IRQ", CurrencyIso4217.IQD, LanguageIso639.en, null),

	/**
	 * Ireland Country.
	 */
	IE("IRELAND", "IE", "IRL", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Isle of man Country.
	 */
	IM("ISLE OF MAN", "IM", "IMN", CurrencyIso4217.GBP, LanguageIso639.en, null),

	/**
	 * Israel Country.
	 */
	IL("ISRAEL", "IL", "ISR", CurrencyIso4217.ILS, LanguageIso639.en, null),

	/**
	 * Jamaica Country.
	 */
	JM("JAMAICA", "JM", "JAM", CurrencyIso4217.JMD, LanguageIso639.en, null),

	/**
	 * Japan Country.
	 */
	JP("JAPAN", "JP", "JPN", CurrencyIso4217.JPY, LanguageIso639.en, null),

	/**
	 * Jersey Country.
	 */
	JE("JERSEY", "JE", "JEY", CurrencyIso4217.GBP, LanguageIso639.en, null),

	/**
	 * Jordan Country.
	 */
	JO("JORDAN", "JO", "JOR", CurrencyIso4217.JOD, LanguageIso639.en, null),

	/**
	 * Kazakhstan Country.
	 */
	KZ("KAZAKHSTAN", "KZ", "KAZ", CurrencyIso4217.KZT, LanguageIso639.en, null),

	/**
	 * Kenya Country.
	 */
	KE("KENYA", "KE", "KEN", CurrencyIso4217.KES, LanguageIso639.en, null),

	/**
	 * Kiribati Country.
	 */
	KI("KIRIBATI", "KI", "KIR", CurrencyIso4217.AUD, LanguageIso639.en, null),

	/**
	 * Korea, democratic people's republic of Country (Korea del norte).
	 */
	KP("KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF", "KP", "PRK", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Korea, republic of Country. (Korea del sur, null),
	 */
	KR("KOREA, REPUBLIC OF", "KR", "KOR", CurrencyIso4217.KRW, LanguageIso639.en, null),

	/**
	 * Kuwait Country.
	 */
	KW("KUWAIT", "KW", "KWT", CurrencyIso4217.KWD, LanguageIso639.en, null),

	/**
	 * Kyrgyzstan Country.
	 */
	KG("KYRGYZSTAN", "KG", "KGZ", CurrencyIso4217.KGS, LanguageIso639.en, null),

	/**
	 * Lao people's democratic republic Country.
	 */
	LA("LAO PEOPLE'S DEMOCRATIC REPUBLIC", "LA", "LAO", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Latvia Country.
	 */
	LV("LATVIA", "LV", "LVA", CurrencyIso4217.LVL, LanguageIso639.en, null),

	/**
	 * Lebanon Country.
	 */
	LB("LEBANON", "LB", "LBN", CurrencyIso4217.LBP, LanguageIso639.en, null),

	/**
	 * Lesotho Country.
	 */
	LS("LESOTHO", "LS", "LSO", CurrencyIso4217.LSL, LanguageIso639.en, null),

	/**
	 * Liberia Country.
	 */
	LR("LIBERIA", "LR", "LBR", CurrencyIso4217.LRD, LanguageIso639.en, null),

	/**
	 * Libya Country.
	 */
	LY("LIBYA", "LY", "LBY", CurrencyIso4217.LYD, LanguageIso639.en, null),

	/**
	 * Liechtenstein Country.
	 */
	LI("LIECHTENSTEIN", "LI", "LIE", CurrencyIso4217.CHF, LanguageIso639.en, null),

	/**
	 * Lithuania Country.
	 */
	LT("LITHUANIA", "LT", "LTU", CurrencyIso4217.LTL, LanguageIso639.en, null),

	/**
	 * Luxembourg Country.
	 */
	LU("LUXEMBOURG", "LU", "LUX", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Macao Country.
	 */
	MO("MACAO", "MO", "MAC", CurrencyIso4217.MOP, LanguageIso639.en, null),

	/**
	 * Macedonia, the former yugoslav republic of Country.
	 */
	MK("MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF", "MK", "MKD", CurrencyIso4217.MKD, LanguageIso639.en, null),

	/**
	 * Madagascar Country.
	 */
	MG("MADAGASCAR", "MG", "MDG", CurrencyIso4217.MGA, LanguageIso639.en, null),

	/**
	 * Malawi Country.
	 */
	MW("MALAWI", "MW", "MWI", CurrencyIso4217.MWK, LanguageIso639.en, null),

	/**
	 * Malaysia Country.
	 */
	MY("MALAYSIA", "MY", "MYS", CurrencyIso4217.MYR, LanguageIso639.en, null),

	/**
	 * Maldives Country.
	 */
	MV("MALDIVES", "MV", "MDV", CurrencyIso4217.MVR, LanguageIso639.en, null),

	/**
	 * Mali Country.
	 */
	ML("MALI", "ML", "MLI", CurrencyIso4217.XOF, LanguageIso639.en, null),

	/**
	 * Malta Country.
	 */
	MT("MALTA", "MT", "MLT", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Marshall islands Country.
	 */
	MH("MARSHALL ISLANDS", "MH", "MHL", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Martinique Country.
	 */
	MQ("MARTINIQUE", "MQ", "MTQ", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Mauritania Country.
	 */
	MR("MAURITANIA", "MR", "MRT", CurrencyIso4217.MRO, LanguageIso639.en, null),

	/**
	 * Mauritius Country.
	 */
	MU("MAURITIUS", "MU", "MUS", CurrencyIso4217.MUR, LanguageIso639.en, null),

	/**
	 * Mayotte Country.
	 */
	YT("MAYOTTE", "YT", "MYT", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Micronesia, federated states of Country.
	 */
	FM("MICRONESIA, FEDERATED STATES OF", "FM", "FSM", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Moldova, republic of Country.
	 */
	MD("MOLDOVA, REPUBLIC OF", "MD", "MDA", CurrencyIso4217.MDL, LanguageIso639.en, null),

	/**
	 * Monaco Country.
	 */
	MC("MONACO", "MC", "MCO", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Mongolia Country.
	 */
	MN("MONGOLIA", "MN", "MNG", CurrencyIso4217.MNT, LanguageIso639.en, null),

	/**
	 * Montenegro Country.
	 */
	ME("MONTENEGRO", "ME", "MNE", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Montserrat Country.
	 */
	MS("MONTSERRAT", "MS", "MSR", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Morocco Country.
	 */
	MA("MOROCCO", "MA", "MAR", CurrencyIso4217.MAD, LanguageIso639.en, null),

	/**
	 * Mozambique Country.
	 */
	MZ("MOZAMBIQUE", "MZ", "MOZ", CurrencyIso4217.MZN, LanguageIso639.en, null),

	/**
	 * Myanmar Country.
	 */
	MM("MYANMAR", "MM", "MMR", CurrencyIso4217.MMK, LanguageIso639.en, null),

	/**
	 * Namibia Country.
	 */
	NA("NAMIBIA", "NA", "NAM", CurrencyIso4217.NAD, LanguageIso639.en, null),

	/**
	 * Nauru Country.
	 */
	NR("NAURU", "NR", "NRU", CurrencyIso4217.AUD, LanguageIso639.en, null),

	/**
	 * Nepal Country.
	 */
	NP("NEPAL", "NP", "NPL", CurrencyIso4217.NPR, LanguageIso639.en, null),

	/**
	 * Netherlands Country.
	 */
	NL("NETHERLANDS", "NL", "NLD", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * New caledonia Country.
	 */
	NC("NEW CALEDONIA", "NC", "NLC", CurrencyIso4217.XPF, LanguageIso639.en, null),

	/**
	 * New zealand Country.
	 */
	NZ("NEW ZEALAND", "NZ", "NZL", CurrencyIso4217.NZD, LanguageIso639.en, null),

	/**
	 * Nicaragua Country.
	 */
	NI("NICARAGUA", "NI", "NIC", CurrencyIso4217.NIO, LanguageIso639.en, null),

	/**
	 * Niger Country.
	 */
	NE("NIGER", "NE", "NER", CurrencyIso4217.XOF, LanguageIso639.en, null),

	/**
	 * Nigeria Country.
	 */
	NG("NIGERIA", "NG", "NGA", CurrencyIso4217.NGN, LanguageIso639.en, null),

	/**
	 * Niue Country.
	 */
	NU("NIUE", "NU", "NIU", CurrencyIso4217.NZD, LanguageIso639.en, null),

	/**
	 * Norfolk island Country.
	 */
	NF("NORFOLK ISLAND", "NF", "NFK", CurrencyIso4217.AUD, LanguageIso639.en, null),

	/**
	 * Northern mariana islands Country.
	 */
	MP("NORTHERN MARIANA ISLANDS", "MP", "MNP", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Norway Country.
	 */
	NO("NORWAY", "NO", "NOR", CurrencyIso4217.NOK, LanguageIso639.en, null),

	/**
	 * Oman Country.
	 */
	OM("OMAN", "OM", "OMN", CurrencyIso4217.OMR, LanguageIso639.en, null),

	/**
	 * Pakistan Country.
	 */
	PK("PAKISTAN", "PK", "PAK", CurrencyIso4217.PKR, LanguageIso639.en, null),

	/**
	 * Palau Country.
	 */
	PW("PALAU", "PW", "PWL", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Palestinian territory, occupied Country.
	 */
	PS("PALESTINIAN TERRITORY, OCCUPIED", "PS", "PSE", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Papua new guinea Country.
	 */
	PG("PAPUA NEW GUINEA", "PG", "PNG", CurrencyIso4217.PGK, LanguageIso639.en, null),

	/**
	 * Philippines Country.
	 */
	PH("PHILIPPINES", "PH", "PHL", CurrencyIso4217.PHP, LanguageIso639.en, null),

	/**
	 * Pitcairn Country.
	 */
	PN("PITCAIRN", "PN", "PCN", CurrencyIso4217.NZD, LanguageIso639.en, null),

	/**
	 * Poland Country.
	 */
	PL("POLAND", "PL", "POL", CurrencyIso4217.PLN, LanguageIso639.en, null),

	/**
	 * Puerto rico Country.
	 */
	PR("PUERTO RICO", "PR", "PRI", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Qatar Country.
	 */
	QA("QATAR", "QA", "QAT", CurrencyIso4217.QAR, LanguageIso639.en, null),

	/**
	 * Réunion Country.
	 */
	RE("RÉUNION", "RE", "REU", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Romania Country.
	 */
	RO("ROMANIA", "RO", "ROU", CurrencyIso4217.RON, LanguageIso639.en, null),

	/**
	 * Russian federation Country.
	 */
	RU("RUSSIAN FEDERATION", "RU", "RUS", CurrencyIso4217.RUB, LanguageIso639.en, null),

	/**
	 * Rwanda Country.
	 */
	RW("RWANDA", "RW", "RWA", CurrencyIso4217.RWF, LanguageIso639.en, null),

	/**
	 * Saint barthelemy Country.
	 */
	BL("SAINT BARTHELEMY", "BL", "BLM", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Saint helena, ascension and tristan da cunha Country.
	 */
	SH("SAINT HELENA, ASCENSION AND TRISTAN DA CUNHA", "SH", "SHN", CurrencyIso4217.SHP, LanguageIso639.en, null),

	/**
	 * Saint kitts and nevis Country.
	 */
	KN("SAINT KITTS AND NEVIS", "KN", "KNA", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Saint lucia Country.
	 */
	LC("SAINT LUCIA", "LC", "LCA", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Saint martin (french part) Country.
	 */
	MF("SAINT MARTIN (FRENCH PART)", "MF", "MAF", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Saint pierre and miquelon Country.
	 */
	PM("SAINT PIERRE AND MIQUELON", "PM", "SPM", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Saint vincent and the grenadines Country.
	 */
	VC("SAINT VINCENT AND THE GRENADINES", "VC", "VCT", CurrencyIso4217.XCD, LanguageIso639.en, null),

	/**
	 * Samoa Country.
	 */
	WS("SAMOA", "WS", "WSM", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * San marino Country.
	 */
	SM("SAN MARINO", "SM", "SMR", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Sao tome and principe Country.
	 */
	ST("SAO TOME AND PRINCIPE", "ST", "STP", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Saudi arabia Country.
	 */
	SA("SAUDI ARABIA", "SA", "SAU", CurrencyIso4217.SAR, LanguageIso639.en, null),

	/**
	 * Senegal Country.
	 */
	SN("SENEGAL", "SN", "SEN", CurrencyIso4217.XOF, LanguageIso639.en, null),

	/**
	 * Serbia Country.
	 */
	RS("SERBIA", "RS", "SRB", CurrencyIso4217.RSD, LanguageIso639.en, null),

	/**
	 * Seychelles Country.
	 */
	SC("SEYCHELLES", "SC", "SYC", CurrencyIso4217.SCR, LanguageIso639.en, null),

	/**
	 * Sierra leone Country.
	 */
	SL("SIERRA LEONE", "SL", "SLE", CurrencyIso4217.SLL, LanguageIso639.en, null),

	/**
	 * Singapore Country.
	 */
	SG("SINGAPORE", "SG", "SGP", CurrencyIso4217.SGD, LanguageIso639.en, null),

	/**
	 * Sint maarten (dutch part) Country.
	 */
	SX("SINT MAARTEN (DUTCH PART)", "SX", "SXM", CurrencyIso4217.ANG, LanguageIso639.en, null),

	/**
	 * Slovakia Country.
	 */
	SK("SLOVAKIA", "SK", "SVK", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Slovenia Country.
	 */
	SI("SLOVENIA", "SI", "SVN", CurrencyIso4217.EUR, LanguageIso639.en, null),

	/**
	 * Solomon islands Country.
	 */
	SB("SOLOMON ISLANDS", "SB", "SLB", CurrencyIso4217.SBD, LanguageIso639.en, null),

	/**
	 * Somalia Country.
	 */
	SO("SOMALIA", "SO", "SOM", CurrencyIso4217.SOS, LanguageIso639.en, null),

	/**
	 * South africa Country.
	 */
	ZA("SOUTH AFRICA", "ZA", "ZAF", CurrencyIso4217.ZAR, LanguageIso639.en, null),

	/**
	 * South georgia and the south sandwich islands Country.
	 */
	GS("SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS", "GS", "SGS", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Sri lanka Country.
	 */
	LK("SRI LANKA", "LK", "LKA", CurrencyIso4217.LKR, LanguageIso639.en, null),

	/**
	 * Sudan Country.
	 */
	SD("SUDAN", "SD", "SDN", CurrencyIso4217.SDG, LanguageIso639.en, null),

	/**
	 * Suriname Country.
	 */
	SR("SURINAME", "SR", "SUR", CurrencyIso4217.SRD, LanguageIso639.en, null),

	/**
	 * South Sudan Country.
	 */
	SS("SOUTH SUDAN", "SS", "SSD", CurrencyIso4217.SDG, LanguageIso639.en, null),

	/**
	 * Svalbard and jan mayen Country.
	 */
	SJ("SVALBARD AND JAN MAYEN", "SJ", "SJM", CurrencyIso4217.NOK, LanguageIso639.en, null),

	/**
	 * Swaziland Country.
	 */
	SZ("SWAZILAND", "SZ", "SWZ", CurrencyIso4217.SZL, LanguageIso639.en, null),

	/**
	 * Sweden Country.
	 */
	SE("SWEDEN", "SE", "SWE", CurrencyIso4217.SEK, LanguageIso639.en, null),

	/**
	 * Switzerland Country.
	 */
	CH("SWITZERLAND", "CH", "CHE", CurrencyIso4217.CHF, LanguageIso639.en, null),

	/**
	 * Syrian arab republic Country.
	 */
	SY("SYRIAN ARAB REPUBLIC", "SY", "SYR", CurrencyIso4217.SYP, LanguageIso639.en, null),

	/**
	 * Taiwan, province of china Country.
	 */
	TW("TAIWAN, PROVINCE OF CHINA", "TW", "TWN", CurrencyIso4217.TWD, LanguageIso639.en, null),

	/**
	 * Tajikistan Country.
	 */
	TJ("TAJIKISTAN", "TJ", "TJK", CurrencyIso4217.TJS, LanguageIso639.en, null),

	/**
	 * Tanzania, united republic of Country.
	 */
	TZ("TANZANIA, UNITED REPUBLIC OF", "TZ", "TZA", CurrencyIso4217.TZS, LanguageIso639.en, null),

	/**
	 * Thailand Country.
	 */
	TH("THAILAND", "TH", "THA", CurrencyIso4217.THB, LanguageIso639.en, null),

	/**
	 * Timor-leste Country.
	 */
	TL("TIMOR-LESTE", "TL", "TLS", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Togo Country.
	 */
	TG("TOGO", "TG", "TGO", CurrencyIso4217.XOF, LanguageIso639.en, null),

	/**
	 * Tokelau Country.
	 */
	TK("TOKELAU", "TK", "TKL", CurrencyIso4217.NZD, LanguageIso639.en, null),

	/**
	 * Tonga Country.
	 */
	TO("TONGA", "TO", "TON", CurrencyIso4217.TOP, LanguageIso639.en, null),

	/**
	 * Trinidad and tobago Country.
	 */
	TT("TRINIDAD AND TOBAGO", "TT", "TTO", CurrencyIso4217.TTD, LanguageIso639.en, null),

	/**
	 * Tunisia Country.
	 */
	TN("TUNISIA", "TN", "TUN", CurrencyIso4217.TND, LanguageIso639.en, null),

	/**
	 * Turkey Country.
	 */
	TR("TURKEY", "TR", "TUR", CurrencyIso4217.TRY, LanguageIso639.en, null),

	/**
	 * Turkmenistan Country.
	 */
	TM("TURKMENISTAN", "TM", "TKM", CurrencyIso4217.TMT, LanguageIso639.en, null),

	/**
	 * Turks and caicos islands Country.
	 */
	TC("TURKS AND CAICOS ISLANDS", "TC", "TCA", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Tuvalu Country.
	 */
	TV("TUVALU", "TV", "TUV", CurrencyIso4217.AUD, LanguageIso639.en, null),

	/**
	 * Uganda Country.
	 */
	UG("UGANDA", "UG", "UGA", CurrencyIso4217.UGX, LanguageIso639.en, null),

	/**
	 * Ukraine Country.
	 */
	UA("UKRAINE", "UA", "UKR", CurrencyIso4217.UAH, LanguageIso639.en, null),

	/**
	 * United arab emirates Country.
	 */
	AE("UNITED ARAB EMIRATES", "AE", "ARE", CurrencyIso4217.AED, LanguageIso639.en, null),

	/**
	 * United states minor outlying islands Country.
	 */
	UM("UNITED STATES MINOR OUTLYING ISLANDS", "UM", "UMY", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Uruguay Country.
	 */
	UY("URUGUAY", "UY", "URY", CurrencyIso4217.UYU, LanguageIso639.en, null),

	/**
	 * Uzbekistan Country.
	 */
	UZ("UZBEKISTAN", "UZ", "UZB", CurrencyIso4217.UZS, LanguageIso639.en, null),

	/**
	 * Vanuatu Country.
	 */
	VU("VANUATU", "VU", "VUT", CurrencyIso4217.VUV, LanguageIso639.en, null),

	/**
	 * Venezuela, bolivarian republic of Country.
	 */
	VE("VENEZUELA, BOLIVARIAN REPUBLIC OF", "VE", "VEN", CurrencyIso4217.VEF, LanguageIso639.en, null),

	/**
	 * Viet nam Country.
	 */
	VN("VIET NAM", "VN", "VNM", CurrencyIso4217.VND, LanguageIso639.en, null),

	/**
	 * Virgin islands, british Country.
	 */
	VG("VIRGIN ISLANDS, BRITISH", "VG", "VGB", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Virgin islands, u.s. Country.
	 */
	VI("VIRGIN ISLANDS, U.S.", "VI", "VIR", CurrencyIso4217.USD, LanguageIso639.en, null),

	/**
	 * Wallis and futuna Country.
	 */
	WF("WALLIS AND FUTUNA", "WF", "WLF", CurrencyIso4217.XPF, LanguageIso639.en, null),

	/**
	 * Western sahara Country.
	 */
	EH("WESTERN SAHARA", "EH", "ESH", CurrencyIso4217.MAD, LanguageIso639.en, null),

	/**
	 * Yemen Country.
	 */
	YE("YEMEN", "YE", "YEM", CurrencyIso4217.YER, LanguageIso639.en, null),

	/**
	 * Zambia Country.
	 */
	ZM("ZAMBIA", "ZM", "ZMB", CurrencyIso4217.ZMK, LanguageIso639.en, null),

	/**
	 * Zimbabwe Country.
	 */
	ZW("ZIMBABWE", "ZW", "ZWE", CurrencyIso4217.ZWL, LanguageIso639.en, null);

	/**
	 * The Country Name
	 */
	private final String description;

	/**
	 * The Country ISO Code (3166) alpha 2.
	 */
	private final String isoCode3166;

	/**
	 * The Country ISO Code (3166) alplha 3.
	 */
	private final String isoCode3166Alpha3;

	/**
	 * The default Country ISO Code (4217)
	 */
	private final CurrencyIso4217 currencyIso4217;

	/**
	 * The default language ISO Code (639-1)
	 */
	private final LanguageIso639 languageIso639;

	/**
	 * The time zone
	 */
	private final String timeZone;

	/**
	 * Constructor.
	 *
	 * @param description       the country description.
	 * @param isoCode3166       the iso code 3166 alpha2.
	 * @param isoCode3166Alpha3 the iso code 3166 alpha3.
	 * @param currencyIso4217   the currency iso 4217.
	 * @param languageIso639    the language iso 639.
	 * @param timeZone          The time zone
	 */
	Country(final String description, final String isoCode3166, final String isoCode3166Alpha3,
	        final CurrencyIso4217 currencyIso4217, final LanguageIso639 languageIso639, final String timeZone) {
		this.description = description;
		this.isoCode3166 = isoCode3166;
		this.isoCode3166Alpha3 = isoCode3166Alpha3;
		this.currencyIso4217 = currencyIso4217;
		this.languageIso639 = languageIso639;
		this.timeZone = timeZone;
	}

	/**
	 * Return the country description.
	 *
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * Return the country isco code 3166.
	 *
	 * @return the isoCode3166
	 */
	public String getIsoCode3166() {

		return isoCode3166;
	}

	/**
	 * Return the currency isco code 4217.
	 *
	 * @return the currency iso code 4217
	 */
	public CurrencyIso4217 getCurrencyIso4217() {

		return currencyIso4217;
	}

	/**
	 * Returns the language isco code 639-1.
	 *
	 * @return the languageIso639
	 */
	public LanguageIso639 getLanguageIso639() {

		return languageIso639;
	}

	/**
	 * Returns the current value of isoCode3166Alpha3.
	 *
	 * @return the current value of isoCode3166Alpha3
	 */
	public String getIsoCode3166Alpha3() {

		return isoCode3166Alpha3;
	}

	/**
	 * Returns timeZone attribute
	 *
	 * @return the timeZone
	 */
	public String getTimeZone() {

		return timeZone;
	}

	/**
	 * Return a Country Object from the String (ISO3166 ALPHA2).<br>
	 * Ex. Country.fromString("co") return Country.CO Ex. Country.fromString("CO") return Country.CO
	 * Ex. Coutnry.fromString("XX") return null
	 *
	 * @param isoCode3166 the iso code string
	 * @return Country enum value
	 */
	public static Country fromString(final String isoCode3166) {

		if (isoCode3166 != null) {
			for (final Country country : Country.values()) {
				if (isoCode3166.equalsIgnoreCase(country.toString())) {
					return country;
				}
			}
		}
		return null;
	}

}