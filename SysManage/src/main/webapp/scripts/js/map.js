(function() {  
    window['XR'] = {};  
    var midContainer = new Array();  
    var mapContainer = new Array();  
    var MAPID = 0;  
    function Map(mid) {  
        var type = typeof (mid);  
        if ((type != "string") && (type != "number")) {  
            throw "Map id must be a string or number!";  
        }  
        for (var _c = 0; midContainer[_c]; _c++) {  
            if (mid == midContainer[_c])  
                throw "You have already created Map : " + mid;  
        }  
        var identify = MAPID++;  
        midContainer[identify] = mid;  
        mapContainer[identify] = {};  
        mapContainer[identify]["id"] = mid;  
        this.id = mid;  
        this.prefix = "K_";  
        this.toString = function() {  
            return "This is a map object!";  
        }  
    }  
  
  
    Map.prototype.getMapId = function() {  
        return this.id;  
    }  
    Map.prototype.getMapIndex = function() {  
        var index = -1;  
        for (var _i = 0; mapContainer[_i]; _i++) {  
            if (this.id == mapContainer[_i]["id"]) {  
                index = _i;  
            }  
        }  
        return index;  
    }  
    Map.prototype.put = function(key, value) {  
        if ( typeof (key) != "string") {  
            throw "key must be a string!";  
        }  
        if ( typeof (value) == "function") {  
            throw "value shouldn't be a function!";  
        }  
        if (this.trimStr(key) == "") {  
            throw "key is empty!";  
        }  
        var index = -1;  
        index = this.getMapIndex();  
        if (index != -1) {  
            key = this.prefix + key;  
            mapContainer[index][key] = value;  
        }  
    }  
    Map.prototype.get = function(key) {  
        var index = -1;  
        index = this.getMapIndex();  
        var value = "";  
        if (index != -1) {  
            var _tV = mapContainer[index];  
            key = this.prefix + key;  
            value = (_tV.hasOwnProperty(key)) ? _tV[key] : "You haven't save this key's value!";  
        } else {  
            value = "Current Map has lost connection!";  
        }  
        return value;  
    }  
    Map.prototype.deleteKey = function(key) {  
        var index = -1;  
        index = this.getMapIndex();  
        key = this.prefix + key;  
        var _tV = mapContainer[index];  
        if (_tV.hasOwnProperty(key)) {  
            delete _tV[key];  
        }  
    }  
  
    Map.prototype.clearMap = function() {  
        var index = -1;  
        index = this.getMapIndex();  
        var maxId = MAPID - 1;  
        if (index <= maxId) {  
            for (var t = index; t < maxId; t++) {  
                mapContainer[t] = mapContainer[t + 1];  
                midContainer[t] = midContainer[t + 1];  
            }  
            mapContainer[maxId] = null;  
            midContainer[maxId] = null;  
            this.id = null;  
            this.toString = null;  
            MAPID--;  
        }  
    }  
  
    Map.prototype.trimStr = function(str) {  
        return str.replace(/(^\s*)|(\s*$)/g, "");  
    }  
    Map.prototype.isEmpty = function() {  
        var index = -1;  
        index = this.getMapIndex();  
        if (index != -1) {  
            for (var attr in mapContainer[index]) {  
                //alert(mapContainer[index][attr]);  
                if (attr != "id") {  
                    return false;  
                }  
            }  
        }  
        return true;  
    }  
    Map.prototype.showMap = function() {  
        var index = -1;  
        index = this.getMapIndex();  
        var str = "";  
        if (this.id != null) {  
            str = "Map:\t" + this.id + "\n";  
            for (var attr in mapContainer[index]) {  
                if (attr != "id") {  
                    str += attr + ":\t" + mapContainer[index][attr] + "\n";  
                }  
            }  
        } else {  
            str = "This Map doesn't exist!";  
        }  
        alert(str);  
        return str;  
    }  
    window['XR']['Map'] = Map;  
})() 