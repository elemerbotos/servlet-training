$( document ).ready(function() {
	 $( "#attackersWon" ).hide();
     $( "#defendersWon" ).hide();
});

function nl2br (str, is_xhtml) {   
    var breakTag = (is_xhtml || typeof is_xhtml === 'undefined') ? '<br />' : '<br>';    
    return (str + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, '$1'+ breakTag +'$2');
}

$( ".startButton" ).click(function() {
	$.get('runBattle', function(responseText) { 
	    $('#battleReport').html(nl2br(responseText)); 
	    if(responseText.indexOf('ATTACKERS') > -1){
             $( "#attackersWon" ).show();
        }else{
             $( "#defendersWon" ).show();
        }
	});
	$( this ).hide();
});