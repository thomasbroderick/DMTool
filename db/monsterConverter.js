const fs = require('fs');

fs.readFile('monsters.json', (err, data) => {
    if (err) throw err;
    let arrayOfObjects = JSON.parse(data);
    //console.log(arrayOfObjects);
    var fixedJson = fix(arrayOfObjects);
    writeFixedData("fixedMonsters.json", fixedJson);
});

function fix(input) {
  input.forEach(function(monster){
    var saString = "";
    if (monster.special_abilities && monster.special_abilities.length > 0) {
      for (var i=0; i < monster.special_abilities.length; i++) {
        var ability = monster.special_abilities[i];
        for (var p in ability) {
          saString += p + " : " + ability[p] + "---";
        }
        if ( i < monster.special_abilities.length -1 ) {
          saString += "================================";
        }
      }
    }
    monster.user_id = 1;
    monster.special_abilities = saString;

    var actString = "";
    if (monster.actions && monster.actions.length > 0) {
      for (var i=0; i < monster.actions.length; i++) {
        var action = monster.actions[i];
        for (var p in action) {
          actString += p + " : " + action[p] + "---";
        }
        if ( i < monster.actions.length -1 ) {
          actString += "================================";
        }
      }
    }
    monster.actions = actString;

    var legActString = "";
    if (monster.legendary_actions && monster.legendary_actions.length > 0) {
      for (var i=0; i < monster.legendary_actions.length; i++) {
        var legAction = monster.legendary_actions[i];
        for (var p in legAction) {
          legActString += p + " : " + legAction[p] + "---";
        }
        if ( i < monster.legendary_actions.length -1 ) {
          legActString += "================================";
        }
      }
    }
    monster.legendary_actions = legActString;


  });
  var json = JSON.stringify(input);
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
