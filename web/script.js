/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*jslint browser: true*/
/*global $, jQuery, alert*/

var wwReg = new RegExp(/^.+$/);
var naamReg = new RegExp(/^\D+$/);
var initReg = new RegExp(/^(([A-Z]\.)+)+$/);
var numReg = new RegExp(/^\d+$/);
var postReg = new RegExp(/^\d{4}\s[A-Z]{2}$/);
var telReg = new RegExp(/^\d{10}$/);
var bsnReg = new RegExp(/^\d{7}$/);
var mailReg = new RegExp(/^\w+@\w+\.\w+$/);
var datumReg = new RegExp(/^([0-2]\d|3[0-1])-(0[0-9]|1[0-2])-(\d{4})$/);


$(function () {
    'use strict';
    $('#waarom').hide();
    $('#niet').hide();
    $('#achttien').hide();
    $('#toestemmingGegeven').hide();
});

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
    naam($('input[name="ww"]').get(0), wwReg);
    naam($('input[name="hZiekenhuis"]').get(0), naamReg);
    naam($('input[name="hBehandelaar"]').get(0), naamReg);
    validateWachtwoord();
    validateDatum();
    validateToestemming();

    if (!naam($('input[name="na"]').get(0), naamReg) ||
            !naam($('input[name="ini"]').get(0), initReg) ||
            !naam($('input[name="nu"]').get(0), numReg) ||
            !naam($('input[name="adres"]').get(0), naamReg) ||
            !naam($('input[name="postCode"]').get(0), postReg) ||
            !naam($('input[name="plaats"]').get(0), naamReg) ||
            !naam($('input[name="teli"]').get(0), telReg) ||
            !naam($('input[name="bsNummer"]').get(0), bsnReg) ||
            !naam($('input[name="madres"]').get(0), mailReg) ||
            !naam($('input[name="hZiekenhuis"]').get(0), naamReg) ||
            !naam($('input[name="hBehandelaar"]').get(0), naamReg) ||
            !naam($('input[name="ww"]').get(0), wwReg) ||
            !validateWachtwoord() ||
            !validateDatum() ||
            !validateToestemming()) {
        alert("Niet alles is ingevuld");
        return false;
    } else {
        return true;
    }
}


//TODO deze uitbreiden voor alle wijzigingen
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

function naam(obj, regex) {
    'use strict';
    if (obj.value.match(regex)) {
        $(obj).css({'background-color': 'white'});
        return true;
    } else {
        $(obj).css({'background-color': 'red'});
        return false;
    }
}


function validateWachtwoord() {
    'use strict';
    var ww = $('input[name="ww"]').get(0).value;
    var bevestiging = $('input[name="wwB"]').get(0).value;

    if (ww === "") {
        $($('input[name="wwB"]').get(0)).css({'background-color': 'red'});
        $('#niet').show();
        return false;
    } else if (ww === bevestiging) {
        $($('input[name="wwB"]').get(0)).css({'background-color': 'green'});
        $('#waarom').hide();
        return true;
    } else {
        $($('input[name="wwB"]').get(0)).css({'background-color': 'red'});
        $('#waarom').show();
        return false;
    }
}

function validateDatum() {
    'use strict';
    var ww = $('input[name="datum"]').get(0).value;
    var dag = parseInt(ww.substring(8, 10));
    var maand = parseInt(ww.substring(5, 7));
    var jaar = parseInt(ww.substring(0, 4));
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    if (jaar < yyyy - 18 && (jaar !== '' || maand !== '' || dag !== '')) {
        $($('input[name="datum"]').get(0)).css({'background-color': 'green'});
        $('#achttien').hide();
        return true;
    } else if (jaar === yyyy - 18 && maand <= mm) {

        if ((maand === mm) && dag <= dd) {
            $($('input[name="datum"]').get(0)).css({'background-color': 'green'});
            $('#achttien').hide();
            return true;
        } else if (maand === mm && dag > dd) {
            $($('input[name="datum"]').get(0)).css({'background-color': 'red'});
            $('#achttien').show();
            return false;
        } else {
            $($('input[name="datum"]').get(0)).css({'background-color': 'green'});
            $('#achttien').hide();
            return true;
        }
    } else {
        $($('input[name="datum"]').get(0)).css({'background-color': 'red'});
        $('#achttien').show();
        return false;
    }
}

function validateToestemming() {
    'use strict';
    var toestemming = $('input[name="toestemming"]').get(0).checked;
    if (toestemming) {
        $('#toestemmingGegeven').hide();
        return true;
    } else {
        $('#toestemmingGegeven').show();
        return false;
    }
}
