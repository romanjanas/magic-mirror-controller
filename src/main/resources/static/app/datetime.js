function date_time(timeId, dateId, dayOfWeekId) {
    "use strict";
    var date = new Date(),
        year = date.getFullYear(),
        month = date.getMonth(),
        months = ['ledna', 'února', 'března', 'dubna', 'května', 'června', 'července', 'srpna', 'září', 'října', 'listopadu', 'prosince'],
        d = date.getDate(),
        day = date.getDay(),
        days = ['Neděle', 'Pondělí', 'Úterý', 'Středa', 'Čtvrtek', 'Pátek', 'Sobota'],
        h = date.getHours(),
        m = date.getMinutes(),
        s = date.getSeconds(),
        resultTime,
        resultDate,
        resultDayOfWeek;
    
    if (h < 10) {
        h = "0" + h;
    }
    
    if (m < 10) {
        m = "0" + m;
    }
    
    if (s < 10) {
        s = "0" + s;
    }
    
    resultTime = h + ':' + m;
    resultDate = d + '. ' + months[month] + ' ' + year;
    resultDayOfWeek = days[day];
    document.getElementById(timeId).innerHTML = resultTime;
    document.getElementById(dateId).innerHTML = resultDate;
    document.getElementById(dayOfWeekId).innerHTML = resultDayOfWeek;
    setTimeout('date_time("' + timeId + '", "' + dateId + '", "' + dayOfWeekId + '");', '1000');
    
    return true;
}