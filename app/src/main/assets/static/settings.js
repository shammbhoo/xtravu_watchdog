import playlist from "./playlist.js"
import uploadfile from "./upload.js";
import popup from "./popup.js";
let body = document.querySelector('body')
export default function settings() {
    body.innerHTML = `
       <section class="wrapper">
       <div class="containers display_flex">
              <div class="display_flex_col remotebar">
              <div class="display_flex " style="width: 100%;margin-bottom:30px">
              <svg id="back"viewBox="0 0 28 50" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" clip-rule="evenodd" d="M7.11192 25L27.9457 45.8338L23.7796 50L0.862659 27.0831C0.310299 26.5306 0 25.7813 0 25C0 24.2187 0.310299 23.4694 0.862659 22.9169L23.7796 0L27.9457 4.16617L7.11192 25Z" fill="#0080E1"/>
              </svg>
              <h1 style="color:#0080E1;">Remote Settings</h1>
              <p></p>
              </div>
              <p style="font-size: clamp(18px , 3vw,34px)">Choose an option</p>
              </div>
              <div class="display_flex_col">
              <p class="hover" style="font-size: clamp(20px , 3vw,40px);text-align:center;margin: 10px 0;width: clamp(200px, 30vw, 400px);" id="manage-playlist">Manage Playlist</p>
              <p class="hover" style="font-size: clamp(20px , 3vw,40px);text-align:center;margin: 10px 0;width: clamp(200px, 30vw, 400px);" id="add-web-url">Add Web Url</p>
              <p class="hover" style="font-size: clamp(20px , 3vw,40px);text-align:center;margin: 10px 0;width: clamp(200px, 30vw, 400px);" id="upload-playlist">File Upload</p>

              <div class="display_flex_col">
                  <!-- Other content above -->
                  <div class="switch-container">
                     <p style="font-size: clamp(20px , 3vw,40px);text-align:center;margin: 10px 0;width: clamp(200px, 30vw, 400px);" id="autolaunch">Autolaunch</p>

                      <label class="switch">
                          <input type="checkbox" id="autoLaunchSwitch">
                          <span class="slider"></span>
                      </label>
                  </div>

                  <!-- Radio buttons for player options here -->
              </div>
              <p style="font-size: clamp(18px , 3vw,28px);margin-top: 10px;">Select Video Player</p>

              <div class="player-options" style="font-size: clamp(20px , 3vw,40px);margin-top: 25px;">
                     <!-- Radio button for ExoPlayer -->
                     <div class="player-option">
                         <input type="radio" id="exoPlayer" name="player" value="ExoPlayer" checked>
                         <label for="exoPlayer">Playback Option 1</label>
                     </div>

                     <!-- Radio button for MediaPlayer -->
                     <div class="player-option">
                         <input type="radio" id="androidPlayer" name="player" value="Android MediaPlayer">
                         <label for="androidPlayer">Playback Option 2</label>
                     </div>

                 </div>
              </div>
              </div>
               <div class="logo display_flex_col">
                   <svg class="logoicon" viewBox="0 0 195 101" fill="none" xmlns="http://www.w3.org/2000/svg">
                       <path d="M16.2655 20.733C16.7084 19.4619 17.5077 18.4219 18.6632 17.613C19.8381 16.8041 21.2536 16.3997 22.9099 16.3997C24.3736 16.3997 25.6736 16.7271 26.8099 17.3819C27.9655 18.0367 28.861 18.9708 29.4966 20.1841C30.1514 21.3975 30.4788 22.813 30.4788 24.4308C30.4788 26.0486 30.1514 27.4738 29.4966 28.7064C28.861 29.9197 27.9655 30.8634 26.8099 31.5375C25.6736 32.1923 24.3736 32.5197 22.9099 32.5197C21.2729 32.5197 19.8669 32.1152 18.6921 31.3064C17.5366 30.4782 16.7277 29.4382 16.2655 28.1864V39.6841H14.9655V16.6019H16.2655V20.733ZM29.1499 24.4308C29.1499 23.0056 28.8803 21.773 28.341 20.733C27.8018 19.693 27.041 18.9034 26.0588 18.3641C25.0958 17.8056 23.9788 17.5264 22.7077 17.5264C21.4944 17.5264 20.3966 17.8152 19.4144 18.393C18.4321 18.9515 17.6618 19.7604 17.1032 20.8197C16.5447 21.8597 16.2655 23.0634 16.2655 24.4308C16.2655 25.8175 16.5447 27.0404 17.1032 28.0997C17.6618 29.1397 18.4321 29.9486 19.4144 30.5264C20.3966 31.0849 21.4944 31.3641 22.7077 31.3641C23.9788 31.3641 25.0958 31.0849 26.0588 30.5264C27.041 29.9678 27.8018 29.1686 28.341 28.1286C28.8803 27.0886 29.1499 25.856 29.1499 24.4308ZM41.3078 32.5197C39.8441 32.5197 38.5249 32.1923 37.3501 31.5375C36.1752 30.8826 35.2508 29.9486 34.5767 28.7352C33.9219 27.5026 33.5945 26.0678 33.5945 24.4308C33.5945 22.813 33.9315 21.3975 34.6056 20.1841C35.2797 18.9515 36.2041 18.0175 37.379 17.3819C38.573 16.7271 39.9019 16.3997 41.3656 16.3997C42.8293 16.3997 44.1486 16.7271 45.3234 17.3819C46.4982 18.0175 47.413 18.9419 48.0678 20.1552C48.7419 21.3686 49.079 22.7938 49.079 24.4308C49.079 26.0678 48.7419 27.5026 48.0678 28.7352C47.3938 29.9486 46.4597 30.8826 45.2656 31.5375C44.0908 32.1923 42.7715 32.5197 41.3078 32.5197ZM41.3078 31.3641C42.4441 31.3641 43.5034 31.1138 44.4856 30.613C45.4871 30.093 46.2864 29.313 46.8834 28.273C47.4804 27.233 47.779 25.9523 47.779 24.4308C47.779 22.9286 47.4804 21.6575 46.8834 20.6175C46.2864 19.5775 45.4967 18.8071 44.5145 18.3064C43.5323 17.7864 42.473 17.5264 41.3367 17.5264C40.2004 17.5264 39.1412 17.7864 38.159 18.3064C37.196 18.8071 36.416 19.5775 35.819 20.6175C35.2219 21.6575 34.9234 22.9286 34.9234 24.4308C34.9234 25.9523 35.2123 27.233 35.7901 28.273C36.3871 29.313 37.1671 30.093 38.1301 30.613C39.1123 31.1138 40.1715 31.3641 41.3078 31.3641ZM73.5343 16.6019L68.5943 32.2886H67.3521L62.3543 18.393L57.3276 32.2886H56.0854L51.1454 16.6019H52.5032L56.721 30.8152L61.7476 16.6019H62.9899L67.9876 30.7575L72.2054 16.6019H73.5343ZM90.5092 23.3908C90.5092 24.0841 90.49 24.6041 90.4515 24.9508H76.9026C76.9411 26.3567 77.2492 27.5412 77.827 28.5041C78.4048 29.4671 79.1655 30.1893 80.1092 30.6708C81.0529 31.1523 82.0833 31.393 83.2003 31.393C84.7411 31.393 86.0315 31.0175 87.0715 30.2664C88.1115 29.496 88.7663 28.456 89.0359 27.1464H90.3937C90.0855 28.7449 89.2959 30.0449 88.0248 31.0464C86.7537 32.0286 85.1455 32.5197 83.2003 32.5197C81.7366 32.5197 80.427 32.1923 79.2715 31.5375C78.1159 30.8826 77.2107 29.9486 76.5559 28.7352C75.9011 27.5026 75.5737 26.0678 75.5737 24.4308C75.5737 22.7938 75.8914 21.3686 76.527 20.1552C77.1818 18.9419 78.087 18.0175 79.2426 17.3819C80.3981 16.7271 81.7174 16.3997 83.2003 16.3997C84.7026 16.3997 86.0026 16.7271 87.1003 17.3819C88.2174 18.0175 89.0648 18.8745 89.6426 19.953C90.2203 21.0123 90.5092 22.1582 90.5092 23.3908ZM89.2092 23.8819C89.267 22.4952 89.0166 21.3204 88.4581 20.3575C87.9189 19.3945 87.1774 18.6819 86.2337 18.2197C85.29 17.7382 84.2692 17.4975 83.1714 17.4975C82.0737 17.4975 81.0529 17.7382 80.1092 18.2197C79.1848 18.6819 78.424 19.3945 77.827 20.3575C77.2492 21.3204 76.9411 22.4952 76.9026 23.8819H89.2092ZM95.7381 19.8375C96.1233 18.6819 96.807 17.8056 97.7892 17.2086C98.7715 16.5923 100.023 16.2841 101.545 16.2841V17.6419H101.111C99.5707 17.6419 98.29 18.0849 97.2692 18.9708C96.2485 19.8375 95.7381 21.2626 95.7381 23.2464V32.2886H94.4381V16.6019H95.7381V19.8375ZM118.665 23.3908C118.665 24.0841 118.645 24.6041 118.607 24.9508H105.058C105.096 26.3567 105.405 27.5412 105.982 28.5041C106.56 29.4671 107.321 30.1893 108.265 30.6708C109.208 31.1523 110.239 31.393 111.356 31.393C112.896 31.393 114.187 31.0175 115.227 30.2664C116.267 29.496 116.922 28.456 117.191 27.1464H118.549C118.241 28.7449 117.451 30.0449 116.18 31.0464C114.909 32.0286 113.301 32.5197 111.356 32.5197C109.892 32.5197 108.582 32.1923 107.427 31.5375C106.271 30.8826 105.366 29.9486 104.711 28.7352C104.056 27.5026 103.729 26.0678 103.729 24.4308C103.729 22.7938 104.047 21.3686 104.682 20.1552C105.337 18.9419 106.242 18.0175 107.398 17.3819C108.553 16.7271 109.873 16.3997 111.356 16.3997C112.858 16.3997 114.158 16.7271 115.256 17.3819C116.373 18.0175 117.22 18.8745 117.798 19.953C118.376 21.0123 118.665 22.1582 118.665 23.3908ZM117.365 23.8819C117.422 22.4952 117.172 21.3204 116.613 20.3575C116.074 19.3945 115.333 18.6819 114.389 18.2197C113.445 17.7382 112.425 17.4975 111.327 17.4975C110.229 17.4975 109.208 17.7382 108.265 18.2197C107.34 18.6819 106.579 19.3945 105.982 20.3575C105.405 21.3204 105.096 22.4952 105.058 23.8819H117.365ZM121.785 24.4308C121.785 22.813 122.102 21.3975 122.738 20.1841C123.393 18.9708 124.288 18.0367 125.425 17.3819C126.58 16.7271 127.89 16.3997 129.353 16.3997C130.952 16.3997 132.339 16.8041 133.513 17.613C134.688 18.4026 135.516 19.433 135.998 20.7041V10.9108H137.298V32.2886H135.998V28.1286C135.536 29.4189 134.727 30.4782 133.571 31.3064C132.416 32.1152 131.01 32.5197 129.353 32.5197C127.89 32.5197 126.58 32.1923 125.425 31.5375C124.288 30.8634 123.393 29.9197 122.738 28.7064C122.102 27.4738 121.785 26.0486 121.785 24.4308ZM135.998 24.4308C135.998 23.0634 135.709 21.8597 135.131 20.8197C134.573 19.7604 133.802 18.9515 132.82 18.393C131.838 17.8152 130.74 17.5264 129.527 17.5264C128.256 17.5264 127.139 17.8056 126.176 18.3641C125.213 18.9034 124.462 19.693 123.922 20.733C123.383 21.773 123.113 23.0056 123.113 24.4308C123.113 25.856 123.383 27.0886 123.922 28.1286C124.462 29.1686 125.213 29.9678 126.176 30.5264C127.158 31.0849 128.275 31.3641 129.527 31.3641C130.74 31.3641 131.838 31.0849 132.82 30.5264C133.822 29.9486 134.602 29.1397 135.16 28.0997C135.719 27.0404 135.998 25.8175 135.998 24.4308ZM151.485 20.733C151.966 19.4619 152.785 18.4219 153.94 17.613C155.096 16.8041 156.492 16.3997 158.129 16.3997C159.593 16.3997 160.893 16.7271 162.029 17.3819C163.185 18.0367 164.08 18.9708 164.716 20.1841C165.371 21.3975 165.698 22.813 165.698 24.4308C165.698 26.0486 165.371 27.4738 164.716 28.7064C164.08 29.9197 163.185 30.8634 162.029 31.5375C160.893 32.1923 159.593 32.5197 158.129 32.5197C156.492 32.5197 155.086 32.1152 153.911 31.3064C152.756 30.4975 151.947 29.4575 151.485 28.1864V32.2886H150.185V10.9108H151.485V20.733ZM164.369 24.4308C164.369 23.0056 164.099 21.773 163.56 20.733C163.021 19.693 162.26 18.9034 161.278 18.3641C160.315 17.8056 159.198 17.5264 157.927 17.5264C156.714 17.5264 155.616 17.8152 154.634 18.393C153.651 18.9515 152.881 19.7604 152.322 20.8197C151.764 21.8597 151.485 23.0634 151.485 24.4308C151.485 25.8175 151.764 27.0404 152.322 28.0997C152.881 29.1397 153.651 29.9486 154.634 30.5264C155.616 31.0849 156.714 31.3641 157.927 31.3641C159.198 31.3641 160.315 31.0849 161.278 30.5264C162.26 29.9678 163.021 29.1686 163.56 28.1286C164.099 27.0886 164.369 25.856 164.369 24.4308ZM181.871 16.6019L172.743 39.6552H171.414L174.331 32.2886L167.745 16.6019H169.16L175.054 30.8441L180.543 16.6019H181.871Z" fill="white"/>
                       <path d="M32.8834 49.9633L26.812 73.8716L34.1655 100.005H19.3454C17.8873 93.4181 16.7811 87.749 16.0269 82.9975C15.0213 88.9306 13.9277 94.5997 12.7461 100.005H0L6.56159 73.8716L0 49.9633H12.7461C14.7824 60.1702 15.876 65.965 16.0269 67.3478C17.485 58.8252 18.5912 53.0304 19.3454 49.9633H32.8834ZM52.2665 43.2886V51.17H56.3769V59.0892H52.2665V85.8635C52.2665 89.1569 52.4299 90.9921 52.7567 91.3692C53.1087 91.7463 54.5291 91.9349 57.018 91.9349V100.005H50.8712C47.4019 100.005 44.9256 99.8666 43.4423 99.5901C41.959 99.2884 40.6517 98.6222 39.5204 97.5914C38.3891 96.5355 37.6852 95.3414 37.4086 94.0089C37.1321 92.6514 36.9938 89.4837 36.9938 84.5059V59.0892H33.713V51.17H36.9938V43.2886H52.2665ZM74.9681 49.9633L74.3647 56.5249C76.5771 51.8237 79.7825 49.3348 83.9809 49.0583V66.669C81.1903 66.669 79.1414 67.0461 77.8341 67.8003C76.5268 68.5545 75.7223 69.6104 75.4206 70.9679C75.1189 72.3004 74.9681 75.3926 74.9681 80.2447V100.005H59.7331V49.9633H74.9681ZM101.026 69.3464H86.7337V65.9902C86.7337 62.1186 87.1737 59.1395 88.0536 57.0528C88.9586 54.9411 90.7562 53.0807 93.4462 51.4717C96.1362 49.8627 99.6306 49.0583 103.93 49.0583C109.083 49.0583 112.968 49.9759 115.582 51.8111C118.197 53.6212 119.768 55.8587 120.296 58.5235C120.824 61.1633 121.088 66.6187 121.088 74.8898V100.005H106.268V95.5551C105.337 97.34 104.131 98.685 102.647 99.5901C101.189 100.47 99.4421 100.91 97.4057 100.91C94.7409 100.91 92.2897 100.168 90.0522 98.685C87.8399 97.1766 86.7337 93.8958 86.7337 88.8426V84.7322C86.7337 80.9863 87.3245 78.4346 88.5061 77.077C89.6877 75.7194 92.6165 74.1356 97.2926 72.3255C102.296 70.3646 104.973 69.0447 105.325 68.3659C105.677 67.6871 105.853 66.3044 105.853 64.2178C105.853 61.6032 105.652 59.9063 105.249 59.1269C104.872 58.3224 104.231 57.9202 103.326 57.9202C102.296 57.9202 101.654 58.2596 101.403 58.9384C101.152 59.592 101.026 61.3141 101.026 64.1047V69.3464ZM105.853 76.2097C103.414 77.9946 101.994 79.4905 101.592 80.6972C101.214 81.9039 101.026 83.6386 101.026 85.9012C101.026 88.4907 101.189 90.1625 101.516 90.9167C101.868 91.6709 102.547 92.048 103.553 92.048C104.508 92.048 105.124 91.7589 105.4 91.1807C105.702 90.5773 105.853 89.0186 105.853 86.5046V76.2097ZM157.818 49.9633L150.69 100.005H130.817L123.162 49.9633H136.775L141.037 86.4669C141.363 83.802 141.916 77.2656 142.696 66.8575C143.148 61.0501 143.651 55.4187 144.204 49.9633H157.818ZM195 49.9633V100.005H179.501L179.765 95.8568C178.709 97.5411 177.402 98.8107 175.843 99.6655C174.31 100.495 172.537 100.91 170.526 100.91C168.238 100.91 166.34 100.508 164.832 99.7032C163.323 98.8987 162.205 97.8303 161.476 96.4978C160.772 95.1654 160.332 93.7827 160.156 92.3497C159.98 90.8916 159.892 88.013 159.892 83.714V49.9633H175.127V84.0157C175.127 87.9124 175.24 90.2253 175.466 90.9544C175.717 91.6835 176.371 92.048 177.427 92.048C178.558 92.048 179.225 91.6709 179.426 90.9167C179.652 90.1625 179.765 87.7365 179.765 83.6386V49.9633H195Z" fill="url(#paint0_linear_460_2876)"/>
                       <defs>
                       <linearGradient id="paint0_linear_460_2876" x1="-20.2156" y1="81.6421" x2="212.139" y2="82.2347" gradientUnits="userSpaceOnUse">
                       <stop stop-color="#6F04D9"/>
                       <stop offset="1" stop-color="#05C7F2"/>
                       </linearGradient>
                       </defs>
                       </svg>

               </div>
       <div class="popup"></div>
       </div>
       </section>`
    const deviceID = getSystemId()
     // Get the switch and status elements
     const switchButton = document.getElementById('autoLaunchSwitch');

     // Add an event listener for when the switch changes state
     switchButton.addEventListener('change', () => {

       if (switchButton.checked) {
        sendAutoLaunch(true)
       } else {
          sendAutoLaunch(false)
       }
     });
    document.getElementById('manage-playlist').addEventListener('click', function () {
        playlist(); // Call the playlist function when clicked
    });
    document.getElementById('upload-playlist').addEventListener('click', function () {
        uploadfile(); // Call the playlist function when clicked
    });
    document.getElementById('add-web-url').addEventListener('click', function () {
        let path = "";
        let duration = "";
        let type = "webpage";
        let id = "";
        popup("","settings", id, deviceID, type, path, duration);
    });
    document.getElementById('back').addEventListener('click', function () {
        window.location = '/' // Call the playlist function when clicked
    });

    console.log("setting js System ID:", deviceID);
    function getSystemId() {
        let systemId = localStorage.getItem('systemId');
        if (!systemId) {
            systemId = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                const r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
                return v.toString(16);
            });
            localStorage.setItem('systemId', systemId);
        }
        return systemId;
    }
  async function sendAutoLaunch(autoLaunch) {

        const formData = new URLSearchParams();
        formData.append('autoLaunch', autoLaunch);


        try {
            const response = await fetch('/updateAutoLaunch', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: formData
            });
            const result = await response.json();
            alert(result.message); // Display the message from the server
            // Check if the login was successful
            if (result.status === "success") {
                // alert(data.message);  // You can use a better UI element here like a toast or modal
              //  console.log('Player selection sent successfully:', player);
                if(autoLaunch===true){
                  switchButton.checked = true;
                }
                else{
                 switchButton.checked = false;
                }
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Error connecting to server');
        }
    }
    async function sendPlayerSelection(player) {

        const formData = new URLSearchParams();
        formData.append('devicePlayer', player);


        try {
            const response = await fetch('/updateDevicePlayer', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: formData
            });
            const result = await response.json();
            alert(result.message); // Display the message from the server
            // Check if the login was successful
            if (result.status === "success") {
                // alert(data.message);  // You can use a better UI element here like a toast or modal
                console.log('Player selection sent successfully:', player);
                //fetchDevicePlayerType();
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Error connecting to server');
        }
    }
    // Add event listeners to the radio buttons
    const playerRadios = document.querySelectorAll('input[name="player"]');

    playerRadios.forEach(radio => {
        radio.addEventListener('change', (event) => {
            const selectedPlayer = event.target.value;
            // Call function to send the selected player
            if (document.getElementById('exoPlayer').checked === true) {
                sendPlayerSelection("EXOPLAYER");
            }
            if (document.getElementById('androidPlayer').checked === true) {
                sendPlayerSelection("MEDIAPLAYER");
            }
        });
    });
    async function fetchDevicePlayerType() {

        try {
            const response = await fetch('/getDevicePlayer'); // Adjust this URL as needed
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const result = await response.json();
            // Print the entire JSON response to the console
            console.log('Fetched JSON data:', result);
            if (result.status === "success") {

                const currentPlayer = result.devicePlayer;  // Assume the response is like { "devicePlayer": "EXOPLAYER" }

                // Set the corresponding radio button based on the current player
                if (currentPlayer === "EXOPLAYER") {
                    document.getElementById('exoPlayer').checked = true;
                } else if (currentPlayer === "MEDIAPLAYER") {
                    document.getElementById('androidPlayer').checked = true;
                }


            } else {
                alert(result.message); // Display the error message if not successful
            }
        } catch (error) {
            console.error('Error fetching playlists:', error);
            alert('Failed to load playlists');
        }

    }
    fetchDevicePlayerType();


    async function fetchAutoLaunch() {

            try {
                const response = await fetch('/getAutoLaunch'); // Adjust this URL as needed
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                const result = await response.json();
                // Print the entire JSON response to the console
                console.log('Fetched JSON data:', result);
                if (result.status === "success") {

                    const autoLaunch = result.autoLaunch;  // Assume the response is like { "devicePlayer": "EXOPLAYER" }

                    // Set the corresponding radio button based on the current player
                    if (autoLaunch === "true") {
                        switchButton.checked = true;
                    } else if (autoLaunch === "false") {
                        switchButton.checked = false;
                    }


                } else {
                    alert(result.message); // Display the error message if not successful
                }
            } catch (error) {
                console.error('Error fetching playlists:', error);
                alert('Failed to load playlists');
            }

        }
    fetchAutoLaunch();
}
