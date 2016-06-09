// generic.js
var webContext = "";

function setWebContext(context) {
    webContext = context;
}

function getPrettyPrintJsonString(jqXHR) {
    var jsonString = jqXHR.responseText.replace(/[\t\r\n]+/g, '').trim();
    var jsonObj = JSON.parse(jsonString); // If you need the object, then here you go.
    jsonString = JSON.stringify(jsonObj, null, 4);  // Format pretty print
    return jsonString;
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

    