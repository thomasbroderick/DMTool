const fs = require('fs');
var stringify = require('json-stable-stringify');


var requiredProperties = [
  "user_id",
  "name",
  "equipment_category",
  "weapon_category",
  "rng",
  "cost",
  "damage",
  "weight",
  "properties",
  "description",
  "image_url"
];


fs.readFile('items.json', (err, data) => {
  if (err) throw err;
  let arrayOfObjects = JSON.parse(data);
  //console.log(arrayOfObjects);
  var fixedJson = fix(arrayOfObjects);
  writeFixedData("fixeditems.json", fixedJson);
});

function fix(input) {
  input.forEach(function(item) {

    item.rng = item.range;
    item.user_id = 1;
    item.cost = "" + item.cost.quantity + item.cost.unit;
    if (item.damage) {
    item.damage = "" + item.damage.dice_count + "d" + item.damage.dice_value + " " + item.damage.damage_type.name;}
    if (item.rng) {
    item.rng = "normal: " + item.rng.normal + " long: " + item.rng.long;}

    requiredProperties.forEach(function(prop) {
      if (item[prop] == undefined) {
        item[prop] = null;
      }
    });

    for (var p in item) {
      if (!requiredProperties.includes(p)) {
        delete item[p];
      }
      // for (var subp in p) {
      //   let subpString = "";
      //   subpString += subp + " : " + p[subp] + "---";
      //   p.subp = subpString;
      // }
    }


    var propertiesString = "";
    if (item.properties && item.properties.length > 0) {

      for (var i = 0; i < item.properties.length; i++) {
        var prop = item.properties[i];
        for (var p in prop) {
          propertiesString += p + " : " + prop[p] + "---";
        }
        if (i < item.properties.length - 1) {
          propertiesString += "================================";
        }
      }
    }
    item.properties = propertiesString;

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
