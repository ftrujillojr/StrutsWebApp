// generic.js

function getPrettyPrintJsonString(jqXHR) {
    var jsonString = jqXHR.responseText.replace(/[\t\r\n]+/g, '').trim();
    var jsonObj = JSON.parse(jsonString); // If you need the object, then here you go.
    jsonString = JSON.stringify(jsonObj, null, 4); // Format pretty print
    return jsonString;
}

function emailData_POST_EXAMPLE(webContext) {
    var jsonDataObj = {
        emailData: {
            email: "ftrujillojr@gmail.com",
            firstName: "Francis",
            lastName: "Trujillo"
        }
    };

    var jqxhr = $.ajax({
        async: true, // defaults to true
        cache: false, //defaults to true
        method: "POST", // GET, POST
        url: webContext + "/emailData/",
        contentType: "application/json", // payload type
        dataType: 'json', // Accept <=  json, xml, script, jsonp, html, or text
        data: JSON.stringify(jsonDataObj), // string version of Json object
        beforeSend: function (jqXHR, settings) {
            //jqXHR.setRequestHeader("X-HTTP-Method-Override", "PUT"); // On POST, override method with PUT, DELETE
            jqXHR.url = settings.url; // SAVE URL for these methods => done,fail, always.
            jqXHR.method = settings.method; // same for method.
        },
        global: false, // Do not fire global handlers if false
        timeout: 5000, // in milliseconds
        username: "",
        password: ""
    }).done(function (data, textStatus, jqXHR) { // Pre jQuery 1.9, this was ,success()

        var jsonString = jqXHR.responseText.replace(/[\t\r\n]+/g, '').trim();
        var jsonObj = JSON.parse(jsonString); // If you need the object, then here you go.
        jsonString = JSON.stringify(jsonObj, null, 4); // Format pretty print

        alert("SUCCESS: \n" + jsonString);
    }).fail(function (jqXHR, textStatus, errorThrown) { // Pre jQuery 1.9, this was ,error()

        var jsonString = jqXHR.responseText.replace(/[\t\r\n]+/g, '').trim();
        var jsonObj = JSON.parse(jsonString);
        jsonString = JSON.stringify(jsonObj, null, 4); // Format pretty print

        var errMsg =
                "      ERROR: " + errorThrown +
                "\n        URL: " + jqXHR.url +
                "\n     METHOD: " + jqXHR.method +
                "\n     STATUS: " + jqXHR.status +
                "\n   RESPONSE: " + jsonObj.message;
        console.log(errMsg);
        console.log(jsonString);
        alert(errMsg);
    }).always(function (jqXHR, textStatus) {      // Pre jQuery 1.9, this was .complete()
        // run after done() or fail()
    });
}

function setAjaxGlobals() {
// jqXHR => readyState, status, statusText, responseHTML, responseXML, responseText, getResponseHeader(), statusCode()

    $(document).ajaxComplete(function (event, jqXHR, settings) {
        var msg = "ALWAYS/COMPLETE:      URL: " + settings.url + "\n";
        msg += "          URL: " + settings.url + "\n";
        msg += "       status: " + jqXHR.status + "\n";
        msg += "   statusText: " + jqXHR.statusText + "\n";
        console.log(msg);
    });
    $(document).ajaxError(function (event, jqXHR, settings, errorThrown) {
        var msg = "FAIL/ERROR:\n";
        msg += "          URL: " + settings.url + "\n";
        msg += "  errorThrown: " + errorThrown + "\n";
        msg += "       status: " + jqXHR.status + "\n";
        msg += "   statusText: " + jqXHR.statusText + "\n";
        var jsonObj = $.parseJSON(jqXHR.responseText);
        msg += JSON.stringify(jsonObj, null, 2);
        console.log(msg);
        alert(msg);
    });
}


(function ($) {
    $.fn.clearForm = function () {
        return this.each(function () {
            var type = this.type, tag = this.tagName.toLowerCase();
            if (tag === 'form')
                return $(':input', this).clearForm();
            if (type === 'text' || type === 'password' || tag === 'textarea')
                this.value = '';
            else if (type === 'checkbox' || type === 'radio')
                this.checked = false;
            else if (tag === 'select')
                this.selectedIndex = -1;
        });
    };
})(jQuery);

    