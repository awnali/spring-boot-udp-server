# udp-Server
Spring boot UDP packet receiver

### Build
- mvn install
- docker build .
- docker run -p 5432:5432/udp -d image_id

### Test
- use https://packetsender.com to send UDP message or setup your client by running https://github.com/awnali/Udp-Producer
<img width="894" alt="Screen Shot 2021-11-18 at 7 38 54 PM" src="https://user-images.githubusercontent.com/627361/142446985-3a08de41-e515-41e4-82d5-035d884abdb6.png">
- You should see incoming messages like following
<img width="1408" alt="Screen Shot 2021-11-18 at 7 39 13 PM" src="https://user-images.githubusercontent.com/627361/142447162-edb2f0b2-9094-4fa9-a5d0-13ae947aa68d.png">
