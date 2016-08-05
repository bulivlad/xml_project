<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">

        <html>
            <head>
                <title>Welcome to Pets shop</title>
                <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Bree+Serif"/>
                <style>body {font-family: 'Bree Serif', serif;}</style>
            </head>
            <body>

                <div class      ="headline">
                    <h1>Welcome to Pets shop</h1>
                </div>
                <div class      ="offer">
                </div>
                <xsl:apply-templates select="/petshop" />

            </body>
        </html>
    </xsl:template>

    <xsl:template match="petshop">
        <div>

            <table cellpadding="6" cellspacing="0" align="center" style="margin: 0px auto; background-color:#bdc3c7" border="2px">
                <tr>
                    <td>Images</td>
                    <td>Name</td>
                    <td>Species</td>
                    <td>Sex</td>
                    <td>Breed</td>
                    <td>Size</td>
                    <td>Details</td>
                </tr>
                <xsl:for-each select ="/petshop/animal">
                    <xsl:sort select     ="name" order="ascending"/>
                    <tr>
                        <td><img src             ="{name/@image}" width="120px" height="80px"/></td>
                        <td><xsl:value-of select ="name"/></td>
                        <td><xsl:value-of select ="species"/></td>
                        <td><xsl:value-of select ="sex"/></td>
                        <td><xsl:value-of select ="breed"/></td>
                        <td><xsl:value-of select ="type"/></td>
                        <td><xsl:value-of select ="details"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>

        <br/><br/><br/>

        <div>

            <table cellpadding="6" cellspacing="0" align="center" style="margin: 0px auto; background-color:#bdc3c7" border="2px" >
                <tr>
                    <td>Images</td>
                    <td>Name</td>
                    <td>Species</td>
                    <td>Amount</td>
                    <td>Price</td>
                    <td>Discount</td>
                    <td>Total</td>
                </tr>
                <xsl:for-each select = "/petshop/food">
                    <xsl:sort select = "species" order="ascending"/>
                    <xsl:sort select = "name" order="ascending"/>
                    <tr>
                        <td><img src ="{name/@image}" width="120px" height="80px"/></td>
                        <td><xsl:value-of select ="name"/></td>
                        <td><xsl:value-of select ="species"/></td>
                        <td><xsl:value-of select ="amount"/> (<xsl:value-of select="amount/@unit"/>)</td>
                        <td><xsl:value-of select ="price"/></td>
                        <td>
                            <xsl:choose>
                                <xsl:when test="discount = '0'">
                                    No discount available
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:value-of select ="discount"/>
                                    <xsl:if test="discount/@type = 'percent'">%</xsl:if>
                                    <xsl:if test="discount/@type = 'price'">
                                        <xsl:value-of select="price/@currency"/>
                                    </xsl:if>
                                </xsl:otherwise>
                            </xsl:choose>
                        </td>
                        <td>
                            <xsl:choose>
                                <xsl:when test="discount/@type = 'percent'">
                                    <xsl:value-of select="price - (discount div 100 * price)"/>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:value-of select="price - discount"/>
                                </xsl:otherwise>
                            </xsl:choose>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>

    </xsl:template>

</xsl:stylesheet>