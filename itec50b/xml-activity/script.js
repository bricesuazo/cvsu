let xmlContent = '';
let purchaseDetails = document.getElementById('address');
let tableOrders = document.getElementById('orders');
fetch('PurchaseOrder.xml').then((response)=> {
    response.text().then((xml)=>{
        xmlContent = xml;

        let parser = new DOMParser();
        let xmlDOM = parser.parseFromString(xmlContent, 'application/xml');
        let address = xmlDOM.querySelectorAll('PurchaseOrder');
        let items = xmlDOM.querySelectorAll('Item');


        address.forEach(orderXmlNode => {
            let row = document.createElement('tr');

            //Order Number
            let td = document.createElement('td');
            td.innerText = orderXmlNode.getAttribute('PurchaseOrderNumber');
            row.appendChild(td);

            //Order Date
            td = document.createElement('td');
            td.innerText = orderXmlNode.getAttribute('OrderDate');
            row.appendChild(td);

            //Shipping Address & Billing Address
            for(let i = 0; i < 2; i++){
                td = document.createElement('td');
                td.innerText = orderXmlNode.children[i].getElementsByTagName('Name')[0].innerHTML + "\n" +
                orderXmlNode.children[i].getElementsByTagName('Street')[0].innerHTML + "\n" +
                orderXmlNode.children[i].getElementsByTagName('City')[0].innerHTML + "\n" +
                orderXmlNode.children[i].getElementsByTagName('Zip')[0].innerHTML + "\n" +
                orderXmlNode.children[i].getElementsByTagName('Country')[0].innerHTML;
                row.appendChild(td);
            }

            //Delivery Notes
            td = document.createElement('td');
            td.innerText = orderXmlNode.children[2].innerHTML;
            row.appendChild(td);

            purchaseDetails.children[1].appendChild(row);
        });
        

        items.forEach(itemXmlNode => {
            let row = document.createElement('tr');

            //Product Name
            let td = document.createElement('td');
            td.innerText = itemXmlNode.children[0].innerHTML;
            row.appendChild(td);

            //Quantity
            td = document.createElement('td');
            td.innerText = itemXmlNode.children[1].innerHTML;
            row.appendChild(td);

            //USPrice
            td = document.createElement('td');
            td.innerText = '$' + itemXmlNode.children[2].innerHTML;
            row.appendChild(td);

            //Comment
            td = document.createElement('td');
            if(itemXmlNode.children[3].nodeName == "Comment"){
                td.innerText = itemXmlNode.children[3].innerHTML;
            }
            row.appendChild(td);
            
            //Ship Date
            td = document.createElement('td');
            if(itemXmlNode.children[3].nodeName == "ShipDate"){
                td.innerText = itemXmlNode.children[3].innerHTML;
                
            }
            row.appendChild(td);

            tableOrders.children[1].appendChild(row);
        });
    });
});    