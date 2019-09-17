// Strings and translations
// Data Picker Initialization

 function datesPleines(liste)
 {
     var years = document.getElementsByClassName("picker__select--year")[0].getElementsByTagName("option");
     for ( var i = 0, len =years.length; i < len; i++ ) {
       var year = years[i];
        if ( year.selected === true ) {
            break;
        }
    }
    var months =  document.getElementsByClassName("picker__select--month")[0].getElementsByTagName("option");
    for ( var i = 0, len =months.length; i < len; i++ ) {
        var month = months[i];
         if ( month.selected === true ) {
             break;
         }
    }
     for ( var i = 0, len =liste.length; i < len; i++ ) {
         var dateTab = liste[i].split("-");
         console.log("Date : " +dateTab);

         if (parseInt(dateTab[2]) == parseInt(year.value) && parseInt(dateTab[1]) == parseInt((month.value)) + 1) {

             var jour = document.getElementById("date-picker1_table").getElementsByTagName("tbody")[0].getElementsByClassName("picker__day picker__day--infocus")[parseInt(dateTab[0]) - 1];
             jour.setAttribute("class", "pleins picker__day--disabled ");
             jour.setAttribute("style","background: #E71D36;");
             jour.parentElement.style.background="#E71D36;";
         }
     }

}

function datesDisponible(liste)
{
    var years = document.getElementsByClassName("picker__select--year")[0].getElementsByTagName("option");
    for ( var i = 0, len =years.length; i < len; i++ ) {
      var year = years[i];
       if ( year.selected === true ) {
           break;
       }
   }
   var months =  document.getElementsByClassName("picker__select--month")[0].getElementsByTagName("option");
   for ( var i = 0, len =months.length; i < len; i++ ) {
       var month = months[i];
        if ( month.selected === true ) {
            break;
        }
   }

   for ( var i = 0, len =liste.length; i < len; i++ ){
   var dateTab = liste[i].split("-");

   if(parseInt(dateTab[2] )== parseInt(year.value) && parseInt(dateTab[1]) == parseInt((month.value))+1)
   {

      var jour = document.getElementById("date-picker1_table").getElementsByTagName("tbody")[0].getElementsByClassName("picker__day picker__day--infocus")[parseInt(dateTab[0])-1];
      jour.setAttribute("class","picker__day picker__day--infocus disponible");

   }
   }

}


    

     
