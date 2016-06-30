<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
        <body>
            Category|Label|Desc<br></br>
            <xsl:value-of select="/features/target_market/@label"/>|<xsl:value-of select="/features/target_market/tmkt_overview_medium/@label"/>|<xsl:value-of select="/features/target_market/tmkt_overview_medium"/><br></br>
        <xsl:value-of select="/features/key_selling_points/@label"/>|Key Selling Point|<xsl:for-each select="/features/key_selling_points/*">
            <xsl:value-of select="."/>
        </xsl:for-each>
        </body>
        </html>
    </xsl:template>

</xsl:stylesheet>