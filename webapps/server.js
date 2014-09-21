// A very basic web server in node.js
// Stolen from: Node.js for Front-End Developers by Garann Means (p. 9-10) 
 
var port = 8000;
var serverUrl = "127.0.0.1";
 
var http = require("http");
var path = require("path"); 
var fs = require("fs"); 		
 
console.log("Starting web server at " + serverUrl + ":" + port);
 
http.createServer( function(req, res) {
 
	var now = new Date();
 
	var filename = req.url;
	var fLength = filename.length;
	console.log(filename.substr(fLength-1, fLength));
	if(!!filename  == 0 || filename === "/" || filename.substr(fLength-1, fLength) === '/'){
		filename += "/index.html";
	}
	var ext = "";
	if(filename.indexOf("?") != -1){
		ext = path.extname(filename.substring(0,filename.indexOf("?")));
		filename = filename.substring(0,filename.indexOf("?"));
	}else{
		ext = path.extname(filename);
	}
	var localPath = __dirname;
	var validExtensions = {
		".html" : "text/html",			
		".js": "application/javascript", 
		".css": "text/css",
		".txt": "text/plain",
		".jpg": "image/jpeg",
		".gif": "image/gif",
		".otf": "font/otf",
		".eot": "application/vnd.ms-fontobject",
		".svg": "image/svg+xml",
		".ttf": "font/ttf",
		".woff": "application/x-woff",
		".less": "text/css",
		".scss": "text/css",
		".png": "image/png",
		".ico": "image/x-icon",
		".map": "application/json",
		".json": "application/json"
		
		
	};
	var mimetype = validExtensions[ext];
	
	if (mimetype) {
		
		localPath += filename;
		fs.exists(localPath, function(exists) {
			if(exists) {
				console.log("Serving file: " + localPath);
				getFile(localPath, res, mimetype);
			} else {
				console.log("File not found: " + localPath);
				res.writeHead(404);
				res.end();
			}
		});
 
	} else {
		console.log("Invalid file extension detected: { file: "+filename+", ext: " + ext +", mimetype: " + mimetype);
	}
 
}).listen(port, serverUrl);
 
function getFile(localPath, res, mimeType) {
	fs.readFile(localPath, function(err, contents) {
		if(!err) {
			res.setHeader("Content-Length", contents.length);
			res.setHeader("Content-Type", mimeType);
			res.statusCode = 200;
			res.end(contents);
		} else {
			res.writeHead(500);
			res.end();
		}
	});
}
