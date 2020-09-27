function message()
{
		$.getJSON('/lilei/util/Message',{name:$("#name").val(),connect_information:$("#connect_information").val(),msg:$("#msg").val()},function(data){
			let message = '';
			$.each(data, function(index,item) {
				if(index=="message")
				{
					message = JSON.stringify(item)
				}
			});
			alert(message)
				});
}