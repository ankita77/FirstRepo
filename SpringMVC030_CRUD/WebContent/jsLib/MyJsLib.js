$(document).ready(
		function(){
			$("h1").css({"color":"green", "font-size":"30px", "text-align":"center"});
			$("h3").css({"color":"darkgreen", "font-size":"22px", "text-align":"center"});
			$("#mainMenu a").css({"color":"blue", "font-size":"16px", "text-align":"center"});
			$("#mainMenu a").hover(
					function(){
			$(this).css({"color":"red", "font-size":"18px", "text-align":"center"})		
					},
					function(){
						$(this).css({"color":"blue", "font-size":"16px", "text-align":"center"})		
								}
					
			);
			$("table tr:odd").css({"background-color":"lightblue"});
			$("table tr:even").css({"background-color":"lightgreen"});
			
		}
);
