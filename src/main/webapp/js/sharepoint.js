// sharepoint.js

(function ($) { // Start jQuery namespace

    $.fn.exists = function () {
        return(this.length > 0);
    };

    $.fn.getCurrentUrl = function () {
        // In plain JavaScript => window.location.href
        return $(location).attr('href');
    };

    // var url = "http://www.sitepoint.com/url-parameters-jquery/?city=BOISE";
    //
    // var city = decodeURIComponent($().getParamForUrl('city', url));  
    //
    // http://www.w3schools.com/jsref/jsref_encodeuricomponent.asp
    // http://www.w3schools.com/jsref/jsref_decodeuricomponent.asp
    //
    $.fn.getParamForUrl = function (name, url) {
        var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(url);
        if (results === null) { // Uses === and not ==
            return null;
        } else {
            return results[1] || 0;
        }
    };


    // This will get the parameter by name for the CURRENT URL.
    $.fn.getParam = function (name) {
        var results = $().getParamForUrl(name, $().getCurrentUrl());
        return results;
    };


    $.fn.hideSPLeftNav = function () {
        $("#sideNavBox").css('display', 'none');
        $("#contentBox").css('margin-left', '0px');
    }; // hideSPLeftNav


    $.fn.getSPUserId = function () {
        var userId = _spPageContextInfo.userId;
        return userId;
    }; // getSPUserId 


    // RELATIVE URL for SP2013 current site
    $.fn.getSPRelBaseUrl = function () {
        return L_Menu_BaseUrl;
    };

    // ABSOLUTE URL for SP2013 current site
    $.fn.getSPAbsBaseUrl = function () {
        var siteUrl = window.location.protocol + "//" + window.location.host + $().getSPRelBaseUrl();
        return siteUrl;
    };

    // Returns true/false if a SharePoint form.
    $.fn.isSPForm = function (url) {
        var isForm = false;
        var results = new RegExp("([A-Z][a-z]+Form).aspx\\?").exec(url);

        if (results !== null) {
            isForm = true;
        }
        return isForm;
    };

    // Returns true/false if a DISPLAY SharePoint form.
    $.fn.isSPDispForm = function (url) {
        var isForm = false;
        var results = new RegExp("(DispForm).aspx\\?").exec(url);

        if (results !== null) {
            isForm = true;
        }
        return isForm;
    };
    // Returns true/false if a EDIT SharePoint form.
    $.fn.isSPEditForm = function (url) {
        var isForm = false;
        var results = new RegExp("(EditForm).aspx\\?").exec(url);

        if (results !== null) {
            isForm = true;
        }
        return isForm;
    };

    // Returns true/false if a NEW SharePoint form.
    $.fn.isSPNewForm = function (url) {
        var isForm = false;
        var results = new RegExp("(NewForm).aspx\\?").exec(url);

        if (results !== null) {
            isForm = true;
        }
        return isForm;
    };

    /* Returns a Hash with data like such.
     
     webPartId:  WebPartWPQ6
     ctxNum:  137
     spanTitle:  Agenda
     webPartTitleSpanId:  WebPartTitleWPQ6          
     listGUID:  {9DE3B416-CD5E-4AE2-8116-893EE8A60633}
     viewGUID:  {813BC742-A1ED-4EBC-A6D1-FE859E73CE11}
     excelExport:  http://mosspractice.micron.com/sites/fjt_development/meeting_site/_vti_bin/owssvr.dll?CS=109&Using=_layouts/query.iqy&List=%7B9DE3B416-CD5E-4AE2-8116-893EE8A60633%7D&View=%7B813BC742-A1ED-4EBC-A6D1-FE859E73CE11%7D&CacheControl=1
     
     https://social.msdn.microsoft.com/Forums/en-US/9a9be915-0987-4cd9-9e0a-2ec9532d0468/get-sharepoint-list-view-guid-using-javascript?forum=sharepointdevelopmentprevious
     https://nickgrattan.wordpress.com/2008/04/29/finding-the-id-guid-for-a-sharepoint-list/
     GUIDs looks like this example => {26534EF9-AB3A-46E0-AE56-EFF168BE562F}
     */

    $.fn.getAllGUIDsForPage = function () {
        var listHash = {}; // return dataset
        var baseUrl = $().getSPAbsBaseUrl();

        $("div[id^='WebPartWPQ']").each(function () {
            var grid = false;
            var $thisWebPart = $(this);

            if ($thisWebPart.find("div[id^='spgridcontainer']").length > 0) {
                $thisWebPart = $thisWebPart.find(".ms-listviewgrid");
                grid = true;
            }
            var wpId = $thisWebPart.attr('id');                       // WebPartWPQ6

            $thisWebPart.find(".ms-viewheadertr th").each(function (i) {
                var $thisHeader = $(this);
                if (grid) {
                    $thisWebPart.data("ctxNum", $thisHeader.closest("tbody").find("tr:nth-child(2)").attr("iid").split(",")[0]);
                } else {
                    $thisWebPart.data("ctxNum", $thisHeader.find('div:first').attr('CtxNum'));
                }
            }); // find(".ms-viewheadertr th

            var ctxNum = $thisWebPart.data("ctxNum");
            var wpResults = RegExp(".+(WPQ[0-9]+)$").exec(wpId);

            if (wpResults !== null && ctxNum !== undefined) {
                var ctxNumObj = eval("ctx" + ctxNum);
                var listGUID = ctxNumObj.listName;
                var viewGUID = ctxNumObj.view;
                var listGUIDenc = encodeURIComponent(listGUID);
                var viewGUIDenc = encodeURIComponent(viewGUID);
                var msoZoneCellDivId = "MSOZoneCell_" + wpId;                       // MSOZoneCell_WebPartWPQ6
                var webPartTitleSpanId = "WebPartTitle" + wpResults[1];             // WebPartTitleWPQ6
                var webPartChromeTitle = "WebPart" + wpResults[1] + "_ChromeTitle"; // WebPartWPQ6_ChromeTitle
                var spanTitle = $("span#" + webPartTitleSpanId).attr("title");      // Agenda  (list name)
                var excelExport = baseUrl + "/_vti_bin/owssvr.dll?CS=109&" +
                        "Using=_layouts/query.iqy&List=" +
                        listGUIDenc + "&View=" + viewGUIDenc + "&CacheControl=0";
                var data = {};
                data['webPartId'] = wpId;
                data['ctxNum'] = ctxNum;
                data['spanTitle'] = spanTitle;
                data['msoZoneCellDivId'] = msoZoneCellDivId;
                data['webPartTitleSpanId'] = webPartTitleSpanId;
                data['webPartChromeTitle'] = webPartChromeTitle;
                data['listGUID'] = listGUID;
                data['viewGUID'] = viewGUID;
                data['excelExport'] = excelExport;
                listHash[spanTitle] = data;
            }
        }); // div[id^='WebPartWPQ']
        return listHash;
    }; // getAllGUIDsForPage

})(jQuery); // End jQuery namespace






