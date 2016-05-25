/**
 * This is my catch all error handler that will show me syntax errors and such
 * so we can squash them immediately.
 * 
 * @param {type} msg
 * @param {type} url
 * @param {type} line
 * @param {type} col
 * @param {type} error
 * @returns {Function.suppressErrorAlert|Window.onerror.suppressErrorAlert|Boolean}
 */
window.onerror = function (msg, url, line, col, error) {
    // Note that col & error are new to the HTML 5 spec and may not be 
    // supported in every browser.  It worked for me in Chrome.
    var extra = !col ? '' : '\ncolumn: ' + col;
    extra += !error ? '' : '\nerror: ' + error;

    // You can view the information in an alert to see things working like this:
    alert("Error: " + msg + "\nurl: " + url + "\nline: " + line + extra);

    var suppressErrorAlert = false;
    // If you return true, then error alerts (like in older versions of 
    // Internet Explorer) will be suppressed.
    return suppressErrorAlert;
};
