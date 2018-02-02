this.addEventListener('install', function(event) {
	event.waitUntil(
		caches.open('v1').then(function(cache) {
			return cache.addAll([
				'index.html',
				'src/client/css/index.css',
				'src/client/js/cam.js',
			])
			.then(function() {
				console.log('Success! App is available offline!');
			})
		})
	);
});


self.addEventListener('fetch', function(event) {
	event.respondWith(
	    caches.match(event.request)
    	.then(function(response) {
			return response || fetch(event.request);
		})
  	);
});