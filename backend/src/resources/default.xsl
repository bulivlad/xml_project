<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">

        <!--Author: Vinaya Bhattarai 1305900-->

        <html>
            <head>
                <title>Welcome to Pets store</title>
                <link rel="stylesheet" type="text/css" href="css.css"/>
                <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Bree+Serif"/>
                <style>body {font-family: 'Bree Serif', serif;}</style>
            </head>
            <body>

                <div class      ="headline">
                    <h1>Welcome to Pets Store</h1>
                    <h2>Please select your next family member</h2>
                </div>
                <div class      ="offer">
                </div>
                <xsl:apply-templates select="/petsstore" />

            </body>
        </html>
    </xsl:template>

    <xsl:template match="petsstore">
        <div class="main">

            <table cellpadding="6" cellspacing="0" align="center" style="margin: 0px auto;" >
                <tr class="main">
                    <td>Images</td>
                    <td>Name</td>
                    <td>Species</td>
                    <td>Sex</td>
                    <td>Breed</td>
                    <td>Size</td>
                    <td>Details</td>
                    <td>Make Yours</td>
                </tr>
                <xsl:for-each select ="/petsstore/animal">
                    <xsl:sort select     ="name" order="ascending"/>
                    <tr>
                        <td><img src             ="{name/@image}" width="120px" height="80px"/></td>
                        <td><xsl:value-of select ="name"/></td>
                        <td><xsl:value-of select ="species"/></td>
                        <td><xsl:value-of select ="sex"/></td>
                        <td><xsl:value-of select ="breed"/></td>
                        <td><xsl:value-of select ="type"/></td>
                        <td><xsl:value-of select ="details"/></td>
                        <td><xsl:value-of select ="makeyours"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>

    </xsl:template>
</xsl:stylesheet>