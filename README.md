
<html><head><div id="header"></div><div id="content">
<h1>Country API Service JSON/CSV Docs</h1>
<div id="preamble">
<div class="sectionbody">
<div class="paragraph">
<p>API developed to get information on countries. The API has three main endpoints which ControllerTest generated the documentation:</p>
</div>
<div class="olist arabic">
<ol class="arabic">
<li>
<p><em>GET 10 BIGGEST COUNTRIES BY REGION -> Docker Container: http://159.65.221.35/api/v1/country/region/{region}/biggest</em></p>
</li>
<li>
<p><em>GET COUNTRIES OF A SUBREGION HAVING OVER 3 BORDERS Docker Container: -> http://159.65.221.35/api/v1/country/subregion/{subregion}/borders</em></p>
</li>
<li>
<p><em>GET COUNTRIES OF A SUBREGION PROVIDING THE SUBREGION Docker Container: -> http://159.65.221.35/api/v1/country/subregion/{subregion}/population</em>
-</p>
</li>
</ol>
</div>
</div>
</div>
<div class="sect2">
<h3 id="_i_get_10_biggest_countries_by_region">I. GET 10 BIGGEST COUNTRIES BY REGION</h3>
<div class="paragraph">
<p>One showing how to make a request using cURL:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight"><code class="language-bash hljs" data-lang="bash">$ curl 'https://yourdomainhere.eu:80/api/v1/country/region/oceania/biggest' -i -X GET \
    -H 'Accept: application/json'</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight"><code class="language-bash hljs" data-lang="bash">$ curl 'https://yourdomainhere.eu:80/api/v1/country/region/oceania/biggest' -i -X GET \
    -H 'Accept: text/csv'</code></pre>
</div>
</div>
<div class="paragraph">
<p>One showing the HTTP request:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">GET /api/v1/country/region/oceania/biggest HTTP/1.1
Accept: application/json
Host: yourdomainhere.eu:80</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">GET /api/v1/country/region/oceania/biggest HTTP/1.1
Accept: text/csv
Host: yourdomainhere.eu:80</code></pre>
</div>
</div>
<div class="paragraph">
<p>And one showing the HTTP response:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 1721

[{"name":"Australia","capital":"Canberra","region":"Oceania","subregion":"Australia and New Zealand","population":24117360,"area":7692024.0,"borders":[],"alpha3Code":"AUS"},{"name":"Papua New Guinea","capital":"Port Moresby","region":"Oceania","subregion":"Melanesia","population":8083700,"area":462840.0,"borders":[{"name":"Indonesia","capital":"Jakarta","region":"Asia","subregion":"South-Eastern Asia","population":258705000,"area":1904569.0,"alpha3Code":"IDN"}],"alpha3Code":"PNG"},{"name":"New Zealand","capital":"Wellington","region":"Oceania","subregion":"Australia and New Zealand","population":4697854,"area":270467.0,"borders":[],"alpha3Code":"NZL"},{"name":"Solomon Islands","capital":"Honiara","region":"Oceania","subregion":"Melanesia","population":642000,"area":28896.0,"borders":[],"alpha3Code":"SLB"},{"name":"New Caledonia","capital":"Noum??a","region":"Oceania","subregion":"Melanesia","population":268767,"area":18575.0,"borders":[],"alpha3Code":"NCL"},{"name":"Fiji","capital":"Suva","region":"Oceania","subregion":"Melanesia","population":867000,"area":18272.0,"borders":[],"alpha3Code":"FJI"},{"name":"Vanuatu","capital":"Port Vila","region":"Oceania","subregion":"Melanesia","population":277500,"area":12189.0,"borders":[],"alpha3Code":"VUT"},{"name":"French Polynesia","capital":"Papeet??","region":"Oceania","subregion":"Polynesia","population":271800,"area":4167.0,"borders":[],"alpha3Code":"PYF"},{"name":"Samoa","capital":"Apia","region":"Oceania","subregion":"Polynesia","population":194899,"area":2842.0,"borders":[],"alpha3Code":"WSM"},{"name":"Kiribati","capital":"South Tarawa","region":"Oceania","subregion":"Micronesia","population":113400,"area":811.0,"borders":[],"alpha3Code":"KIR"}]</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">HTTP/1.1 200 OK
Content-Type: text/csv
Content-Length: 868

"ALPHA3CODE","AREA","BORDERS","CAPITAL","NAME","POPULATION","REGION","SUBREGION"
"AUS","7692024.0","","Canberra","Australia","24117360","Oceania","Australia and New Zealand"
"PNG","462840.0","[IDN]","Port Moresby","Papua New Guinea","8083700","Oceania","Melanesia"
"NZL","270467.0","","Wellington","New Zealand","4697854","Oceania","Australia and New Zealand"
"SLB","28896.0","","Honiara","Solomon Islands","642000","Oceania","Melanesia"
"NCL","18575.0","","Noum??a","New Caledonia","268767","Oceania","Melanesia"
"FJI","18272.0","","Suva","Fiji","867000","Oceania","Melanesia"
"VUT","12189.0","","Port Vila","Vanuatu","277500","Oceania","Melanesia"
"PYF","4167.0","","Papeet??","French Polynesia","271800","Oceania","Polynesia"
"WSM","2842.0","","Apia","Samoa","194899","Oceania","Polynesia"
"KIR","811.0","","South Tarawa","Kiribati","113400","Oceania","Micronesia"</code></pre>
</div>
</div>
<div class="paragraph">
<p>Response Body:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-none hljs">[{"name":"Australia","capital":"Canberra","region":"Oceania","subregion":"Australia and New Zealand","population":24117360,"area":7692024.0,"borders":[],"alpha3Code":"AUS"},{"name":"Papua New Guinea","capital":"Port Moresby","region":"Oceania","subregion":"Melanesia","population":8083700,"area":462840.0,"borders":[{"name":"Indonesia","capital":"Jakarta","region":"Asia","subregion":"South-Eastern Asia","population":258705000,"area":1904569.0,"alpha3Code":"IDN"}],"alpha3Code":"PNG"},{"name":"New Zealand","capital":"Wellington","region":"Oceania","subregion":"Australia and New Zealand","population":4697854,"area":270467.0,"borders":[],"alpha3Code":"NZL"},{"name":"Solomon Islands","capital":"Honiara","region":"Oceania","subregion":"Melanesia","population":642000,"area":28896.0,"borders":[],"alpha3Code":"SLB"},{"name":"New Caledonia","capital":"Noum??a","region":"Oceania","subregion":"Melanesia","population":268767,"area":18575.0,"borders":[],"alpha3Code":"NCL"},{"name":"Fiji","capital":"Suva","region":"Oceania","subregion":"Melanesia","population":867000,"area":18272.0,"borders":[],"alpha3Code":"FJI"},{"name":"Vanuatu","capital":"Port Vila","region":"Oceania","subregion":"Melanesia","population":277500,"area":12189.0,"borders":[],"alpha3Code":"VUT"},{"name":"French Polynesia","capital":"Papeet??","region":"Oceania","subregion":"Polynesia","population":271800,"area":4167.0,"borders":[],"alpha3Code":"PYF"},{"name":"Samoa","capital":"Apia","region":"Oceania","subregion":"Polynesia","population":194899,"area":2842.0,"borders":[],"alpha3Code":"WSM"},{"name":"Kiribati","capital":"South Tarawa","region":"Oceania","subregion":"Micronesia","population":113400,"area":811.0,"borders":[],"alpha3Code":"KIR"}]</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-none hljs">"ALPHA3CODE","AREA","BORDERS","CAPITAL","NAME","POPULATION","REGION","SUBREGION"
"AUS","7692024.0","","Canberra","Australia","24117360","Oceania","Australia and New Zealand"
"PNG","462840.0","[IDN]","Port Moresby","Papua New Guinea","8083700","Oceania","Melanesia"
"NZL","270467.0","","Wellington","New Zealand","4697854","Oceania","Australia and New Zealand"
"SLB","28896.0","","Honiara","Solomon Islands","642000","Oceania","Melanesia"
"NCL","18575.0","","Noum??a","New Caledonia","268767","Oceania","Melanesia"
"FJI","18272.0","","Suva","Fiji","867000","Oceania","Melanesia"
"VUT","12189.0","","Port Vila","Vanuatu","277500","Oceania","Melanesia"
"PYF","4167.0","","Papeet??","French Polynesia","271800","Oceania","Polynesia"
"WSM","2842.0","","Apia","Samoa","194899","Oceania","Polynesia"
"KIR","811.0","","South Tarawa","Kiribati","113400","Oceania","Micronesia"</code></pre>
</div>
</div>
<div class="paragraph">
<p>Response Fields:</p>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 33.3333%;">
<col style="width: 33.3334%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Path</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].name</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Name of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].capital</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Capital of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].region</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Region of the Country (Europe, Oceania, Americas, etc).</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].subregion</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Subregion of the Country (South America, Easter Europe, Western Europe, etc).</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].population</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Number</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Population of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].area</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Number</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Area of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].borders</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Array</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Borders of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].alpha3Code</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Alpha3 Code of the country (BRA, FRA, POL).</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="_ii_get_countries_of_a_subregion_having_over_3_borders">II. GET COUNTRIES OF A SUBREGION HAVING OVER 3 BORDERS</h3>
<div class="paragraph">
<p>One showing how to make a request using cURL:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight"><code class="language-bash hljs" data-lang="bash">$ curl 'https://yourdomainhere.eu:80/api/v1/country/subregion/southamerica/borders' -i -X GET \
    -H 'Accept: application/json'</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight"><code class="language-bash hljs" data-lang="bash">$ curl 'https://yourdomainhere.eu:80/api/v1/country/subregion/southamerica/borders' -i -X GET \
    -H 'Accept: text/csv'</code></pre>
</div>
</div>
<div class="paragraph">
<p>One showing the HTTP request:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">GET /api/v1/country/subregion/southamerica/borders HTTP/1.1
Accept: application/json
Host: yourdomainhere.eu:80</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">GET /api/v1/country/subregion/southamerica/borders HTTP/1.1
Accept: text/csv
Host: yourdomainhere.eu:80</code></pre>
</div>
</div>
<div class="paragraph">
<p>And one showing the HTTP response:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 6017

[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"}],"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"BRA"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"},{"name":"Panama","capital":"Panama City","region":"Americas","subregion":"Central America","population":3814672,"area":75417.0,"alpha3Code":"PAN"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"COL"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"}],"alpha3Code":"PER"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"France","capital":"Paris","region":"Europe","subregion":"Western Europe","population":66710000,"area":640679.0,"alpha3Code":"FRA"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"}],"alpha3Code":"SUR"}]</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">HTTP/1.1 200 OK
Content-Type: text/csv
Content-Length: 725

"ALPHA3CODE","AREA","BORDERS","CAPITAL","NAME","POPULATION","REGION","SUBREGION"
"ARG","2780400.0","[BOL,BRA,CHL,PRY,URY]","Buenos Aires","Argentina","43590400","Americas","South America"
"BOL","1098581.0","[ARG,BRA,CHL,PRY,PER]","Sucre","Bolivia (Plurinational State of)","10985059","Americas","South America"
"BRA","8515767.0","[ARG,BOL,COL,GUF,GUY,PRY,PER,SUR,URY,VEN]","Bras??lia","Brazil","206135893","Americas","South America"
"COL","1141748.0","[BRA,ECU,PAN,PER,VEN]","Bogot??","Colombia","48759958","Americas","South America"
"PER","1285216.0","[BOL,BRA,CHL,COL,ECU]","Lima","Peru","31488700","Americas","South America"
"SUR","163820.0","[BRA,GUF,FRA,GUY]","Paramaribo","Suriname","541638","Americas","South America"</code></pre>
</div>
</div>
<div class="paragraph">
<p>Response Body:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-none hljs">[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"}],"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"BRA"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"},{"name":"Panama","capital":"Panama City","region":"Americas","subregion":"Central America","population":3814672,"area":75417.0,"alpha3Code":"PAN"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"COL"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"}],"alpha3Code":"PER"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"France","capital":"Paris","region":"Europe","subregion":"Western Europe","population":66710000,"area":640679.0,"alpha3Code":"FRA"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"}],"alpha3Code":"SUR"}]</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-none hljs">"ALPHA3CODE","AREA","BORDERS","CAPITAL","NAME","POPULATION","REGION","SUBREGION"
"ARG","2780400.0","[BOL,BRA,CHL,PRY,URY]","Buenos Aires","Argentina","43590400","Americas","South America"
"BOL","1098581.0","[ARG,BRA,CHL,PRY,PER]","Sucre","Bolivia (Plurinational State of)","10985059","Americas","South America"
"BRA","8515767.0","[ARG,BOL,COL,GUF,GUY,PRY,PER,SUR,URY,VEN]","Bras??lia","Brazil","206135893","Americas","South America"
"COL","1141748.0","[BRA,ECU,PAN,PER,VEN]","Bogot??","Colombia","48759958","Americas","South America"
"PER","1285216.0","[BOL,BRA,CHL,COL,ECU]","Lima","Peru","31488700","Americas","South America"
"SUR","163820.0","[BRA,GUF,FRA,GUY]","Paramaribo","Suriname","541638","Americas","South America"</code></pre>
</div>
</div>
<div class="paragraph">
<p>Response Fields:</p>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 33.3333%;">
<col style="width: 33.3334%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Path</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].name</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Name of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].capital</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Capital of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].region</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Region of the Country (Europe, Oceania, Americas, etc).</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].subregion</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Subregion of the Country (South America, Easter Europe, Western Europe, etc).</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].population</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Number</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Population of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].area</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Number</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Area of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].borders</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Array</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Borders of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].alpha3Code</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Alpha3 Code of the country (BRA, FRA, POL).</p></td>
</tr>
</tbody>
</table>
</div>
<div class="sect2">
<h3 id="_iii_get_countries_of_a_subregion_providing_the_subregion_population">III. GET COUNTRIES OF A SUBREGION PROVIDING THE SUBREGION POPULATION</h3>
<div class="paragraph">
<p>One showing how to make a request using cURL:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight"><code class="language-bash hljs" data-lang="bash">$ curl 'https://yourdomainhere.eu:80/api/v1/country/subregion/southamerica/population' -i -X GET \
    -H 'Accept: application/json'</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight"><code class="language-bash hljs" data-lang="bash">$ curl 'https://yourdomainhere.eu:80/api/v1/country/subregion/southamerica/population' -i -X GET \
    -H 'Accept: text/csv'</code></pre>
</div>
</div>
<div class="paragraph">
<p>One showing the HTTP request:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">GET /api/v1/country/subregion/southamerica/population HTTP/1.1
Accept: application/json
Host: yourdomainhere.eu:80</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">GET /api/v1/country/subregion/southamerica/population HTTP/1.1
Accept: text/csv
Host: yourdomainhere.eu:80</code></pre>
</div>
</div>
<div class="paragraph">
<p>And one showing the HTTP response:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 10251

[{"totalPopulation":418606839,"countries":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"}],"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"CHL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"},{"name":"Panama","capital":"Panama City","region":"Americas","subregion":"Central America","population":3814672,"area":75417.0,"alpha3Code":"PAN"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"COL"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"borders":[{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"ECU"},{"name":"Falkland Islands (Malvinas)","capital":"Stanley","region":"Americas","subregion":"South America","population":2563,"area":12173.0,"borders":[],"alpha3Code":"FLK"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"}],"alpha3Code":"GUF"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"GUY"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"}],"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"}],"alpha3Code":"PER"},{"name":"South Georgia and the South Sandwich Islands","capital":"King Edward Point","region":"Americas","subregion":"South America","population":30,"area":null,"borders":[],"alpha3Code":"SGS"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"France","capital":"Paris","region":"Europe","subregion":"Western Europe","population":66710000,"area":640679.0,"alpha3Code":"FRA"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"}],"alpha3Code":"SUR"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"}],"alpha3Code":"URY"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"}],"alpha3Code":"VEN"}]}]</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-http hljs" data-lang="http">HTTP/1.1 200 OK
Content-Type: text/csv
Content-Length: 2182

"COUNTRIES","TOTALPOPULATION"
"Name;Argentina|Capital;Buenos Aires|Alpha3Code;ARG|Subregion;South America|Region;Americas|Area;2780400.0|Population;43590400|
[BOL|BRA|CHL|PRY|URY|]Name;Bolivia (Plurinational State of)|Capital;Sucre|Alpha3Code;BOL|Subregion;South America|Region;Americas|Area;1098581.0|Population;10985059|
[ARG|BRA|CHL|PRY|PER|]Name;Brazil|Capital;Bras??lia|Alpha3Code;BRA|Subregion;South America|Region;Americas|Area;8515767.0|Population;206135893|
[ARG|BOL|COL|GUF|GUY|PRY|PER|SUR|URY|VEN|]Name;Chile|Capital;Santiago|Alpha3Code;CHL|Subregion;South America|Region;Americas|Area;756102.0|Population;18191900|
[ARG|BOL|PER|]Name;Colombia|Capital;Bogot??|Alpha3Code;COL|Subregion;South America|Region;Americas|Area;1141748.0|Population;48759958|
[BRA|ECU|PAN|PER|VEN|]Name;Ecuador|Capital;Quito|Alpha3Code;ECU|Subregion;South America|Region;Americas|Area;276841.0|Population;16545799|
[COL|PER|]Name;Falkland Islands (Malvinas)|Capital;Stanley|Alpha3Code;FLK|Subregion;South America|Region;Americas|Area;12173.0|Population;2563|
[]Name;French Guiana|Capital;Cayenne|Alpha3Code;GUF|Subregion;South America|Region;Americas|Area;null|Population;254541|
[BRA|SUR|]Name;Guyana|Capital;Georgetown|Alpha3Code;GUY|Subregion;South America|Region;Americas|Area;214969.0|Population;746900|
[BRA|SUR|VEN|]Name;Paraguay|Capital;Asunci??n|Alpha3Code;PRY|Subregion;South America|Region;Americas|Area;406752.0|Population;6854536|
[ARG|BOL|BRA|]Name;Peru|Capital;Lima|Alpha3Code;PER|Subregion;South America|Region;Americas|Area;1285216.0|Population;31488700|
[BOL|BRA|CHL|COL|ECU|]Name;South Georgia and the South Sandwich Islands|Capital;King Edward Point|Alpha3Code;SGS|Subregion;South America|Region;Americas|Area;null|Population;30|
[]Name;Suriname|Capital;Paramaribo|Alpha3Code;SUR|Subregion;South America|Region;Americas|Area;163820.0|Population;541638|
[BRA|GUF|FRA|GUY|]Name;Uruguay|Capital;Montevideo|Alpha3Code;URY|Subregion;South America|Region;Americas|Area;181034.0|Population;3480222|
[ARG|BRA|]Name;Venezuela (Bolivarian Republic of)|Capital;Caracas|Alpha3Code;VEN|Subregion;South America|Region;Americas|Area;916445.0|Population;31028700|
[BRA|COL|GUY|]","418606839"</code></pre>
</div>
</div>
<div class="paragraph">
<p>Response Body:</p>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-none hljs">[{"totalPopulation":418606839,"countries":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"}],"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"alpha3Code":"URY"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"CHL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"},{"name":"Panama","capital":"Panama City","region":"Americas","subregion":"Central America","population":3814672,"area":75417.0,"alpha3Code":"PAN"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"COL"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"borders":[{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"alpha3Code":"PER"}],"alpha3Code":"ECU"},{"name":"Falkland Islands (Malvinas)","capital":"Stanley","region":"Americas","subregion":"South America","population":2563,"area":12173.0,"borders":[],"alpha3Code":"FLK"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"}],"alpha3Code":"GUF"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"alpha3Code":"SUR"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"alpha3Code":"VEN"}],"alpha3Code":"GUY"},{"name":"Paraguay","capital":"Asunci??n","region":"Americas","subregion":"South America","population":6854536,"area":406752.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"}],"alpha3Code":"PRY"},{"name":"Peru","capital":"Lima","region":"Americas","subregion":"South America","population":31488700,"area":1285216.0,"borders":[{"name":"Bolivia (Plurinational State of)","capital":"Sucre","region":"Americas","subregion":"South America","population":10985059,"area":1098581.0,"alpha3Code":"BOL"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Chile","capital":"Santiago","region":"Americas","subregion":"South America","population":18191900,"area":756102.0,"alpha3Code":"CHL"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Ecuador","capital":"Quito","region":"Americas","subregion":"South America","population":16545799,"area":276841.0,"alpha3Code":"ECU"}],"alpha3Code":"PER"},{"name":"South Georgia and the South Sandwich Islands","capital":"King Edward Point","region":"Americas","subregion":"South America","population":30,"area":null,"borders":[],"alpha3Code":"SGS"},{"name":"Suriname","capital":"Paramaribo","region":"Americas","subregion":"South America","population":541638,"area":163820.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"French Guiana","capital":"Cayenne","region":"Americas","subregion":"South America","population":254541,"area":null,"alpha3Code":"GUF"},{"name":"France","capital":"Paris","region":"Europe","subregion":"Western Europe","population":66710000,"area":640679.0,"alpha3Code":"FRA"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"}],"alpha3Code":"SUR"},{"name":"Uruguay","capital":"Montevideo","region":"Americas","subregion":"South America","population":3480222,"area":181034.0,"borders":[{"name":"Argentina","capital":"Buenos Aires","region":"Americas","subregion":"South America","population":43590400,"area":2780400.0,"alpha3Code":"ARG"},{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"}],"alpha3Code":"URY"},{"name":"Venezuela (Bolivarian Republic of)","capital":"Caracas","region":"Americas","subregion":"South America","population":31028700,"area":916445.0,"borders":[{"name":"Brazil","capital":"Bras??lia","region":"Americas","subregion":"South America","population":206135893,"area":8515767.0,"alpha3Code":"BRA"},{"name":"Colombia","capital":"Bogot??","region":"Americas","subregion":"South America","population":48759958,"area":1141748.0,"alpha3Code":"COL"},{"name":"Guyana","capital":"Georgetown","region":"Americas","subregion":"South America","population":746900,"area":214969.0,"alpha3Code":"GUY"}],"alpha3Code":"VEN"}]}]</code></pre>
</div>
</div>
<div class="listingblock">
<div class="content">
<pre class="highlightjs highlight nowrap"><code class="language-none hljs">"COUNTRIES","TOTALPOPULATION"
"Name;Argentina|Capital;Buenos Aires|Alpha3Code;ARG|Subregion;South America|Region;Americas|Area;2780400.0|Population;43590400|
[BOL|BRA|CHL|PRY|URY|]Name;Bolivia (Plurinational State of)|Capital;Sucre|Alpha3Code;BOL|Subregion;South America|Region;Americas|Area;1098581.0|Population;10985059|
[ARG|BRA|CHL|PRY|PER|]Name;Brazil|Capital;Bras??lia|Alpha3Code;BRA|Subregion;South America|Region;Americas|Area;8515767.0|Population;206135893|
[ARG|BOL|COL|GUF|GUY|PRY|PER|SUR|URY|VEN|]Name;Chile|Capital;Santiago|Alpha3Code;CHL|Subregion;South America|Region;Americas|Area;756102.0|Population;18191900|
[ARG|BOL|PER|]Name;Colombia|Capital;Bogot??|Alpha3Code;COL|Subregion;South America|Region;Americas|Area;1141748.0|Population;48759958|
[BRA|ECU|PAN|PER|VEN|]Name;Ecuador|Capital;Quito|Alpha3Code;ECU|Subregion;South America|Region;Americas|Area;276841.0|Population;16545799|
[COL|PER|]Name;Falkland Islands (Malvinas)|Capital;Stanley|Alpha3Code;FLK|Subregion;South America|Region;Americas|Area;12173.0|Population;2563|
[]Name;French Guiana|Capital;Cayenne|Alpha3Code;GUF|Subregion;South America|Region;Americas|Area;null|Population;254541|
[BRA|SUR|]Name;Guyana|Capital;Georgetown|Alpha3Code;GUY|Subregion;South America|Region;Americas|Area;214969.0|Population;746900|
[BRA|SUR|VEN|]Name;Paraguay|Capital;Asunci??n|Alpha3Code;PRY|Subregion;South America|Region;Americas|Area;406752.0|Population;6854536|
[ARG|BOL|BRA|]Name;Peru|Capital;Lima|Alpha3Code;PER|Subregion;South America|Region;Americas|Area;1285216.0|Population;31488700|
[BOL|BRA|CHL|COL|ECU|]Name;South Georgia and the South Sandwich Islands|Capital;King Edward Point|Alpha3Code;SGS|Subregion;South America|Region;Americas|Area;null|Population;30|
[]Name;Suriname|Capital;Paramaribo|Alpha3Code;SUR|Subregion;South America|Region;Americas|Area;163820.0|Population;541638|
[BRA|GUF|FRA|GUY|]Name;Uruguay|Capital;Montevideo|Alpha3Code;URY|Subregion;South America|Region;Americas|Area;181034.0|Population;3480222|
[ARG|BRA|]Name;Venezuela (Bolivarian Republic of)|Capital;Caracas|Alpha3Code;VEN|Subregion;South America|Region;Americas|Area;916445.0|Population;31028700|
[BRA|COL|GUY|]","418606839"</code></pre>
</div>
</div>
<div class="paragraph">
<p>Response Fields:</p>
</div>
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 33.3333%;">
<col style="width: 33.3333%;">
<col style="width: 33.3334%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Path</th>
<th class="tableblock halign-left valign-top">Type</th>
<th class="tableblock halign-left valign-top">Description</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].totalPopulation</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Number</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Subregion population.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].name</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Name of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].capital</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Capital of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].region</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Region of the Country (Europe, Oceania, Americas, etc).</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].subregion</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Subregion of the Country (South America, Easter Europe, Western Europe, etc).</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].population</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Number</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Population of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].area</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Number</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Area of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].borders</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>Array</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Borders of the Country.</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>[].countries[].alpha3Code</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock"><code>String</code></p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Borders of the Country.</p></td>
</tr>
</tbody>
</table>
</div>
</div><div id="footer"></div>
</body></html>
