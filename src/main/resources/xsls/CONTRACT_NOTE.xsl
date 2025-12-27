<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
    <xsl:output encoding="UTF-8" indent="yes" method="xml" standalone="no" omit-xml-declaration="no"/>
    <xsl:template match="contractNote">
        <fo:root language="EN">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="master-page-layout" page-height="297mm" page-width="210mm" margin-top="5mm" margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
                    <fo:region-body margin-top="45mm" margin-bottom="5mm"/>
                    <fo:region-before region-name="static-page-details" extent="40mm" display-align="before" precedence="true"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="master-page-layout">
                <fo:static-content flow-name="static-page-details">
                    <fo:table table-layout="fixed" width="100%" font-size="10pt" border-color="black" border-width="0.4mm" border-style="solid">
                        <fo:table-column column-width="20%" column-number="1"/>
                        <fo:table-column column-width="5%" column-number="2"/>
                        <fo:table-column column-width="40%" column-number="3"/>
                        <fo:table-column column-width="35%" column-number="4"/>
                        <fo:table-body>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm" padding-top="2mm">
									<fo:block>Contract Code</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-right="2mm" padding-top="2mm">
									<fo:block>:</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" text-align="right" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="clientDetails/clientCode"/></fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm">
									<fo:block>Name</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-right="2mm">
									<fo:block>:</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" text-align="right" padding-left="2mm">
									<fo:block><xsl:value-of select="clientDetails/name"/> </fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm">
									<fo:block>Address</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-right="2mm">
									<fo:block>:</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" text-align="right" padding-left="2mm">
									<fo:block><xsl:value-of select="clientDetails/address/addressLine1"/> </fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-right="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" text-align="right" padding-left="2mm">
									<fo:block><xsl:value-of select="clientDetails/address/addressLine2"/> </fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-right="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" text-align="right" padding-left="2mm">
									<fo:block><xsl:value-of select="clientDetails/address/addressLine3"/> </fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
								<fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-right="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" text-align="right" padding-left="2mm">
									<fo:block><xsl:value-of select="clientDetails/address/city"/>, <xsl:value-of select="clientDetails/address/state"/> - <xsl:value-of select="clientDetails/address/postCode"/>, <xsl:value-of select="clientDetails/address/country"/></fo:block>
								</fo:table-cell>
							</fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body" border-collapse="collapse" reference-orientation="0">
                    <fo:block>TRADE SUMMARY</fo:block>
                    <fo:table table-layout="fixed" width="100%" font-size="10pt" border-color="black" border-width="0.35mm" border-style="solid" text-align="center" display-align="center" space-after="5mm">
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-column column-width="proportional-column-width(10)"/>
                        <fo:table-body font-size="95%">
                            <fo:table-row height="8mm">
                                <fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm" padding-top="2mm">
									<fo:block>Trade Date</fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>:</fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="right" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeSummary/tradeDate"/></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="2" text-align="right" padding-left="2mm" padding-top="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="left" padding-left="2mm" padding-top="2mm">
									<fo:block>Settlement Date</fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>:</fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="right" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeSummary/settlementDate"/></fo:block>
								</fo:table-cell>
                            </fo:table-row>
                            <fo:table-row height="8mm">
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Segment</fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Trade Type</fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Trade Quantity</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Market Rate</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Brokerage</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Stamp Tax</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Other Charge</fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Total</fo:block>
								</fo:table-cell>
                            </fo:table-row>
                            <xsl:for-each select="tradeSummary/tradeDetails/individualTrades/trade/trade">
                                <fo:table-row height="8mm">
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="segment"/></fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeType"/></fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeQuantity"/></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="marketRate"/></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="brokerage"/></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="stampTax"/></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="otherCharge"/></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="total"/></fo:block>
								</fo:table-cell>
                            </fo:table-row>
                            </xsl:for-each>
                            <fo:table-row height="8mm">
                                <fo:table-cell number-columns-spanned="2" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block>Total</fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeSummary/tradeDetails/totalTrades/quantity"/></fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeSummary/tradeDetails/totalTrades/totalBrokerage"/></fo:block>
								</fo:table-cell>
								<fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeSummary/tradeDetails/totalTrades/totalStampTax"/></fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeSummary/tradeDetails/totalTrades/totalOtherCharges"/></fo:block>
								</fo:table-cell>
                                <fo:table-cell number-columns-spanned="1" text-align="center" padding-left="2mm" padding-top="2mm">
									<fo:block><xsl:value-of select="tradeSummary/tradeDetails/totalTrades/summaryTotal"/></fo:block>
								</fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:block>TRANSACTION SUMMMARY</fo:block>
                    
                    <fo:block id="end-of-document">
                        <fo:instream-foreign-object>
                            <svg width="200mm" height="150mm" version="1.1" xmlns="http://www.w3.org/2000/svg">
                                <path d="M153 334
C153 334 151 334 151 334
C151 339 153 344 156 344
C164 344 171 339 171 334
C171 322 164 314 156 314
C142 314 131 322 131 334
C131 350 142 364 156 364
C175 364 191 350 191 334
C191 311 175 294 156 294
C131 294 111 311 111 334
C111 361 131 384 156 384
C186 384 211 361 211 334
C211 300 186 274 156 274" style="fill:yellow;stroke:red;stroke-width:2"/>
                            </svg>
                        </fo:instream-foreign-object>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>