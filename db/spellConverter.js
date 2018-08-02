const fs = require('fs');
var stringify = require('json-stable-stringify');


var requiredProperties = [
  "user_id", "name", "description", "range", "components", "material", "ritual", "duration", "concentration", "casting_time", "level", "school", "classes", "higher_lvl"
];


fs.readFile('spells.json', (err, data) => {
  if (err) throw err;
  let arrayOfObjects = JSON.parse(data);
  //console.log(arrayOfObjects);
  var fixedJson = fix(arrayOfObjects);
  writeFixedData("fixedspells.json", fixedJson);
});

function fix(input) {
  input.forEach(function(spell) {
    spell.description = spell.desc;
    spell.higher_lvl = spell.higher_level;
    spell.user_id = 1;
    spell.school = "" + spell.school.name;

    requiredProperties.forEach(function(prop) {
      if (spell[prop] == undefined) {
        spell[prop] = null;
      }
    });

    for (var p in spell) {
      if (!requiredProperties.includes(p)) {
        delete spell[p];
      }
      if (Array.isArray(p)) {
        p = p.toString();
      }
    }

    var classesString = "";
    if (spell.classes && spell.classes.length > 0) {

      for (var i = 0; i < spell.classes.length; i++) {
        var spclass = spell.classes[i];
        spclass.url = null;
        for (var p in spclass) {
          classesString += p + " : " + spclass[p] + "---";
        }
        if (i < spell.classes.length - 1) {
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
    if (err) {
      return console.log(err);
    }
    console.log("Fixed data saved to " + fileName);
  });
}
