// JavaScript Document
var p = {

  0: "1K",
  1: "1.5K",
  2: "2K",
  3: "2.5K",
  4: "3K",
  5: "3.5K",
  6: "4K",
  7: "4.5K",
  8: "5K",
  9: "5.5K",
  10: "6K",
  11: "6.5K",
  12: "7K",
  13: "7.5K",
  14: "8K",
  15: "8.5K",
  16: "9K",
  17: "9.5K",
  18: "10K",

};

var t = {

  0: "1000",
  1: "1500",
  2: "2000",
  3: "2500",
  4: "3000",
  5: "3500",
  6: "4000",
  7: "4500",
  8: "5000",
  9: "5500",
  10: "6000",
  11: "6500",
  12: "7000",
  13: "7500",
  14: "8000",
  15: "8500",
  16: "9000",
  17: "9500",
  18: "10000",


}

var obj = {
  '24month' : {
    'quarterly' : '1.41',
    'monthly' : '1.28',
    'weekly' : '1.2'
  },
  '18month' : {
    'quarterly' : '1.38',
    'monthly' : '1.25',
    'weekly' : '1.8'
  },
  '12month' : {

    'quarterly' : '1.35',
    'monthly' : '1.225',
    'weekly' : '1.15'
  }
};

$(document).ready(function() {

  $("#total").val("1000");



  $("#slider_amirol").slider({
    range: "min",
    animate: true,

    min: 0,
    max: 18,
    step: 1,
    slide:
      function(event, ui)
      {
        update(1,ui.value); //changed
        calcualtePrice(ui.value);
      }
  });

  $('.month').on('click',function(event) {
    var id = $(this).attr('id');

    $('.month').removeClass('selected-month');
    $(this).addClass('selected-month');
    $(".month").removeClass("active-month");
    $(this).addClass("active-month");

    $('#month').val(id);

    calcualtePrice()
  });

  $('.term').on('click',function(event) {
    var id = $(this).attr('id');

    $('.term').removeClass('selected-term');
    $(this).addClass('selected-term');
    $(".term").removeClass("active-term");
    $(this).addClass("active-term");
    $('#term').val(id);

    calcualtePrice()
  });

  update();
  calcualtePrice();
});



function update(slider,val) {

  if(undefined === val) val = 0;
  var amount = p[val];

  $('#sliderVal').val(val);

  $('#slider_amirol a').html('<label><span class="glyphicon glyphicon-chevron-left"></span> '+amount+' <span class="glyphicon glyphicon-chevron-right"></span></label>');
}

$.postJSON = function(url, data, callback) {
  return jQuery.ajax({
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    'type': 'POST',
    'url': url,
    'data': JSON.stringify(data),
    'dataType': 'json',
    'success': callback
  });
};

function calcualtePrice(val){

  if(undefined === val)
    val = $('#sliderVal').val();

  var month = $('#month').val();
  var term = $('#term').val();

  if(month == "24month"){
    month = 24;
  }
  else if(month == "18month"){
    month = 18;
  }
  else{
    month =12;
  }
  var totalPrice = t[val]*term;

  var url = 'http://localhost:8080/java2/api/calculateLoan';
  var data = {
    amount: Number(t[val]),
    duration: month,
    term: term
  };

  $.postJSON(url, data, function (data, status) {
    $("#total").val(Number(data.total).toFixed(2));
    $("#total12").val((Number(data.total)/12).toFixed(2));
    $("#total52").val((Number(data.total)/52).toFixed(2));
  });
}
