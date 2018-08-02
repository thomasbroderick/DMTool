const fs = require('fs');
var stringify = require('json-stable-stringify');


var requiredProperties = [
"user_id", "name", "description", "range", "components", "material", "ritual", "duration", "concentration", "casting_time", "level", "school", "classes", "higher_lvl"];


fs.readFile('spell1.json', (err, data) => {
    if (err) throw err;
    let arrayOfObjects = JSON.parse(data);
    //console.log(arrayOfObjects);
    var fixedJson = fix(arrayOfObjects);
    writeFixedData("fixedspells.json", fixedJson);
});

function fix(input) {
  input.forEach(function(spell){
    requiredProperties.forEach(function(prop){
      if ( spell[prop] == undefined ) {
        spell[prop] = null;
      }
    });

    for ( var p in spell ) {
      if ( ! requiredProperties.includes(p)) {
        delete spell[p];
      }
      if (Array.isArray(p)) {
        p = p.toString();
      }
    }

    var schoolString = "";
    if (spell.school && spell.school > 0) {
      for (var i=0; i < spell.school.length; i++) {
        var school = spell.school[i];
        school.url = null;
        for (var p in school) {
          schoolString += p + " : " + school[p] + "---";
        }
        if ( i < spell.school -1 ) {
          schoolString += "================================";
        }
      }
    }
    spell.user_id = 1;
    spell.school = schoolString;

    var classesString = "";
    if (spell.classes && spell.classes.length > 0) {

      for (var i=0; i < spell.classes.length; i++) {
        var spclass = spell.classes[i];
        spclass.url = null;
        for (var p in spclass) {
          classesString += p + " : " + spclass[p] + "---";
        }
        if ( i < spell.classes.length -1 ) {
          classesString += "================================";
        }
      }
    }
    spell.classes = classesString;

  });
  //var json = JSON.stringify(input);
  //var json = JSON.stringify(input, Object.keys(input).sort());
  var json = stringify(input);

  return json;
}

function writeFixedData(fileName, jsonData) {
  fs.writeFile(fileName, jsonData, function(err) {
    if(err) {
        return console.log(err);
    }
    console.log("Fixed data saved to " + fileName);
});
}
