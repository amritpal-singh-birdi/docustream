<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	<xsl:output encoding="UTF-8" indent="yes" method="xml" standalone="no" omit-xml-declaration="no" />
	<xsl:template match="/">
		<fo:root language="EN">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="master-page-layout" page-height="297mm" page-width="210mm" margin-top="5mm" margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
					<fo:region-body margin-top="80mm" margin-bottom="5mm" />
					<fo:region-before region-name="static-page-details" extent="80mm" display-align="before"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="master-page-layout">
				<fo:static-content flow-name="static-page-details">
					<fo:block border-after-style="double" border-after-width="4pt"> <!-- border-style="solid" border-width="2pt" -->
						<fo:block margin-top="1mm" margin-left="2mm" margin-right="2mm" font-weight="bold" font-size="16pt">INVOICE</fo:block> <!-- border-style="dotted" border-width="1pt"  -->
						<fo:block margin-left="2mm" margin-right="2mm" border-after-style="solid" border-after-width="2pt"></fo:block> <!-- border-style="dotted" border-width="1pt" -->
						<fo:block>
							<fo:table table-layout="fixed" width="100%" font-size="10pt"> <!-- border-color="black" border-width="0.4mm" border-style="solid" -->
								<fo:table-column column-width="35%" column-number="1" />
								<fo:table-column column-width="35%" column-number="2" />
								<fo:table-column column-width="30%" column-number="3" />
								<fo:table-body>
									<fo:table-row>
										<fo:table-cell number-columns-spanned="2" display-align="after">
											<fo:block margin-top = "2mm" margin-left="2mm" margin-right="2mm" margin-bottom="2mm" text-align="left"> <!-- border-style="dotted" border-width="1pt"  -->
												TEAM IT Solutions: 143B Murtenstrasse 3008 Bern
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block margin-top = "2mm" margin-left="2mm" margin-right="2mm" margin-bottom="2mm" text-align="right"> <!-- border-style="dotted" border-width="1pt" -->
												<fo:inline>
													<fo:external-graphic src="src//main//resources//SampleImage.png" />
												</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</fo:block>
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body" border-collapse="collapse" reference-orientation="0">
					<fo:block>
						<fo:table table-layout="fixed" width="100%" font-size="10pt" background-color="#e0e0e0">
							<fo:table-column column-width="25%" column-number="1" />
							<fo:table-column column-width="25%" column-number="2" />
							<fo:table-column column-width="25%" column-number="3" />
							<fo:table-column column-width="25%" column-number="4" />
							<fo:table-body>
								<fo:table-row>
										<fo:table-cell number-columns-spanned="1">
											<fo:block>
												<fo:table table-layout="fixed" width="100%">
													<fo:table-column column-width="50%" column-number="1" />
													<fo:table-column column-width="50%" column-number="2" />
													<fo:table-body>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>Invoice Number</fo:block>
															</fo:table-cell>
														</fo:table-row>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>123456789</fo:block>
															</fo:table-cell>
														</fo:table-row>
													</fo:table-body>
												</fo:table>
												 <!-- border-style="dotted" border-width="1pt"  -->
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												<fo:table table-layout="fixed" width="100%">
													<fo:table-column column-width="50%" column-number="1" />
													<fo:table-column column-width="50%" column-number="2" />
													<fo:table-body>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>Issue Date</fo:block>
															</fo:table-cell>
														</fo:table-row>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>01.12.2025</fo:block>
															</fo:table-cell>
														</fo:table-row>
													</fo:table-body>
												</fo:table><!-- border-style="dotted" border-width="1pt" -->
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												<fo:table table-layout="fixed" width="100%">
													<fo:table-column column-width="50%" column-number="1" />
													<fo:table-column column-width="50%" column-number="2" />
													<fo:table-body>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>Due Date</fo:block>
															</fo:table-cell>
														</fo:table-row>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>31.12.2025</fo:block>
															</fo:table-cell>
														</fo:table-row>
													</fo:table-body>
												</fo:table><!-- border-style="dotted" border-width="1pt" -->
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												<fo:table table-layout="fixed" width="100%">
													<fo:table-column column-width="50%" column-number="1" />
													<fo:table-column column-width="50%" column-number="2" />
													<fo:table-body>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>Invoice Amount</fo:block>
															</fo:table-cell>
														</fo:table-row>
														<fo:table-row>
															<fo:table-cell number-columns-spanned="2">
																<fo:block>CHF 150</fo:block>
															</fo:table-cell>
														</fo:table-row>
													</fo:table-body>
												</fo:table><!-- border-style="dotted" border-width="1pt" -->
											</fo:block>
										</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:block margin="6mm"></fo:block>
						<fo:table table-layout="fixed" width="100%" font-size="10pt" border-after-style="solid" border-after-width="3pt">
							<fo:table-column column-width="25%" column-number="1" />
							<fo:table-column column-width="25%" column-number="2" />
							<fo:table-column column-width="25%" column-number="3" />
							<fo:table-column column-width="25%" column-number="4" />
							<fo:table-body>
								<fo:table-row>
										<fo:table-cell number-columns-spanned="1">
											<fo:block>
												Description
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												Unit Price
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												Quantity
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												Amount
											</fo:block>
										</fo:table-cell>
								</fo:table-row>
								<xsl:for-each select="">
									<fo:table-row>
										<fo:table-cell number-columns-spanned="1">
											<fo:block>
												<xsl:value-of select=""/>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												<xsl:value-of select=""/>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												<xsl:value-of select=""/>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell number-columns-spanned="1" text-align="left">
											<fo:block >
												<xsl:value-of select=""/>
											</fo:block>
										</fo:table-cell>
								</fo:table-row>
								</xsl:for-each>
							</fo:table-body>
						</fo:table>
						
						
					</fo:block>
					<fo:block id="end-of-document">
						<fo:instream-foreign-object>
							<svg width="200mm" height="150mm" version="1.1"
								xmlns="http://www.w3.org/2000/svg">
								<path
									d="M153 334
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
C211 300 186 274 156 274"
									style="fill:yellow;stroke:red;stroke-width:2" />
							</svg>
						</fo:instream-foreign-object>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>