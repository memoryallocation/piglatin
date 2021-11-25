# piglatin
to hit this endpoint: 
1.-you should do a GET request: http://localhost:8080/api/v1/translator/{word} where {word} is the word to be translated
2.-Responses:
if all is good
{
    "ok": true,
    "message": "success",
    "body": "appyhay"
}
if something is wrong
{
    "ok": false,
    "message": "Word with digits",
    "body": null
}
