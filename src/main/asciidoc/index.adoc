= Country API Service JSON Docs
Renan Silva;
:doctype: book
:icons: font
:source-highlighter: highlightjs

API developed to get information on countries. The API has three main endpoints:

1. _GET 10 BIGGEST COUNTRIES BY REGION_
2. _GET COUNTRIES OF A SUBREGION HAVING OVER 3 BORDERS_
3. _GET COUNTRIES OF A SUBREGION PROVIDING THE SUBREGION POPULATION_
-


=== I. GET 10 BIGGEST COUNTRIES BY REGION

One showing how to make a request using cURL:

include::{snippets}/v1/country/region/curl-request.adoc[]

One showing the HTTP request:

include::{snippets}/v1/country/region/http-request.adoc[]

And one showing the HTTP response:

include::{snippets}/v1/country/region/http-response.adoc[]

Response Body:
include::{snippets}/v1/country/region/response-body.adoc[]

Response Fields:
include::{snippets}/v1/country/region/response-fields.adoc[]

=== II. GET COUNTRIES OF A SUBREGION HAVING OVER 3 BORDERS

One showing how to make a request using cURL:

include::{snippets}/v1/country/subregion/borders/curl-request.adoc[]

One showing the HTTP request:

include::{snippets}/v1/country/subregion/borders/http-request.adoc[]

And one showing the HTTP response:

include::{snippets}/v1/country/subregion/borders/http-response.adoc[]

Response Body:
include::{snippets}/v1/country/subregion/borders/response-body.adoc[]

=== III. GET COUNTRIES OF A SUBREGION PROVIDING THE SUBREGION POPULATION

One showing how to make a request using cURL:

include::{snippets}/v1/country/subregion/population/curl-request.adoc[]

One showing the HTTP request:

include::{snippets}/v1/country/subregion/population/http-request.adoc[]

And one showing the HTTP response:

include::{snippets}/v1/country/subregion/population/http-response.adoc[]

Response Body:
include::{snippets}/v1/country/subregion/population/response-body.adoc[]

