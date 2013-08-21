/**
 * Scans all the glyphs in the range and returns a list with those available
 *
 * @requires jQuery, PubSub
 * @author Cristian Dobre
 */
( function( $, d, w, s, r ){
	
	
	var e, glyphs = false, st = [], empty, iv, not = i = 0;
	
	/**
	 * Uses pubsub to trigger event after the search is finished
	 */
	$.fn.iconGlyphs = function( c ){
		
		if( ! glyphs ) $.subscribe( 'icon_font_glyphs', function( v, k ){ c( k ) } );
		else c( glyphs );
	
	} 
	
	/**
	 * Get empty glyph width only after the page is loaded
	 */
	$( w ).load( function(){
		
		if( typeof e == 'undefined' ) return ;
		
		empty = e.scrollWidth;
		
		/**
		 * Set the first glyph
		 */
		e.innerHTML = String.fromCharCode( s );
		
		/**
		 * Uses an async mode, allowing the page to redraw
		 */
		iv = w.setInterval( function(){
			
			if( e.scrollWidth == empty ) not ++;
			else{					
				not = 0;
				st.push( s + i );		
			}
			
			/**
			 * Increase index or finish the search
			 */
			if( i < r && not < 16 ) i++;
			else {
				w.clearInterval( iv );
				glyphs = st;
				$.publish( 'icon_font_glyphs', [ st ] );
			}
			
			e.innerHTML = String.fromCharCode( s + i );
		
		}, 5 );
		
	})
	
	$( d ).ready( function(){
		
		/**
		 * Set an empty glyph to the tester div
		 */
		e = $( '#glypher' ).html( String.fromCharCode( 61439 ) ).get( 0 );
		
	});
	

})( jQuery, document, window, 61440, 512 );
