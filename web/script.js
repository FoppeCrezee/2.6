/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*jslint browser: true*/
/*global $, jQuery, alert*/

var naamReg = new RegExp(/^\D+$/);
var initReg = new RegExp(/^(([A-Z]\.)+)+$/);
var numReg = new RegExp(/^\d+$/);
var postReg = new RegExp(/^\d{4}\s[A-Z]{2}$/);
var telReg = new RegExp(/^\d{10}$/);
var bsnReg = new RegExp(/^\d{7}$/);
var mailReg = new RegExp(/^\w+@\w+\.\w+$/);

function naam(obj, regex) {
    'use strict';
    if (obj.value.match(regex)) {
		$(obj).css({'background-color' : 'white'});
		return false;
    } else {
        $(obj).css({'background-color' : 'red'});
		return true;
    }
}

function validateForm() {
	'use strict';
	naam($('input[name="na"]').get(0), naamReg);
	naam($('input[name="ini"]').get(0), initReg);
	naam($('input[name="nu"]').get(0), numReg);
	naam($('input[name="adres"]').get(0), naamReg);
	naam($('input[name="postCode"]').get(0), postReg);
	naam($('input[name="plaats"]').get(0), naamReg);
	naam($('input[name="teli"]').get(0), telReg);
	naam($('input[name="bsNummer"]').get(0), bsnReg);
	naam($('input[name="madres"]').get(0), mailReg);
	
	if (naam($('input[name="na"]').get(0), naamReg) ||
			naam($('input[name="ini"]').get(0), initReg) ||
			naam($('input[name="nu"]').get(0), numReg) ||
			naam($('input[name="adres"]').get(0), naamReg) ||
			naam($('input[name="postCode"]').get(0), postReg) ||
			naam($('input[name="plaats"]').get(0), naamReg) ||
			naam($('input[name="teli"]').get(0), telReg) ||
			naam($('input[name="bsNummer"]').get(0), bsnReg) ||
			naam($('input[name="madres"]').get(0), mailReg)) {
        alert("Niet alles is ingevuld");
        return false;
    } else {
		return true;
	}
}

function validateWijzigingen() {
	'use strict';
	naam($('input[name="vNaam"]').get(0), naamReg);
        naam($('input[name="ww"]').get(0), naamReg);
	
	if (naam($('input[name="vNaam"]').get(0), naamReg) ||
			naam($('input[name="ww"]').get(0), naamReg)) {
        alert("Niet alles is ingevuld");
        return false;
    } else {
		return true;
	}
}
