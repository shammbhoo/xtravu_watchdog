import settings from "./settings.js";
let body=document.querySelector('body')
export default function uploadfile(){
body.innerHTML=`
   <section class="wrapper">
        <div class="containers display_flex_col">
            <div class="display_flex_col remotebar">
            <div class="display_flex w-100" >
                <svg id="back"  viewBox="0 0 28 50" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M7.11192 25L27.9457 45.8338L23.7796 50L0.862659 27.0831C0.310299 26.5306 0 25.7813 0 25C0 24.2187 0.310299 23.4694 0.862659 22.9169L23.7796 0L27.9457 4.16617L7.11192 25Z" fill="#0080E1"/>
                    </svg>
                    <h1 style="color:#0080E1;">File Upload</h1>
                <p></p>
                </div>
                  </div>
                <div class="display_flex_col" style="height:290px;">
                <img src="/static/CloudArrowUp.png"/>
         <div class="file-input-container">
    <form id="upload-form">
      <!-- Hidden file input -->
      <input type="file" id="fileInput" name="file" accept="image/*,video/*">
      <!-- Label styled to look like a button -->
      <label for="fileInput" class="custom-file-upload">
        Upload Files
      </label>
    </form>

    <!-- Media preview container -->
    <div class="preview-container" id="preview-container">
      <img id="imgPreview" style="display:none;">
      <video id="videoPreview" controls style="display:none;"></video>
    </div>
  </div>
          </div>

            <button class="bluebtn btn w-100" style="background: #0080E1;font-size: clamp(20px,3vw,40px);padding: 20px;" id="submitButton">Submit</button>
        <!-- Loader Element -->
            <div id="loader" class="loader" style="display: none;">
              <div class="loader-spinner"></div>
              Uploading...
            </div>
        </div>
    </section>`
    document.getElementById('back').addEventListener('click', function() {
        settings(); // Call the playlist function when clicked
    });
    const fileInput = document.getElementById('fileInput');
    const imgPreview = document.getElementById('imgPreview');
    const videoPreview = document.getElementById('videoPreview');
    const previewContainer = document.getElementById('preview-container');
    let selectedFilePath = ''; // Variable to store the blob URL or file path
    let duration = '5'; //varibale
    let type = ''
    const deviceID=getSystemId()

    function showLoader() {
      document.getElementById('loader').style.display = 'block';
    }

    function hideLoader() {
      document.getElementById('loader').style.display = 'none';
    }
    // Handle file selection
    fileInput.addEventListener('change', () => {
     uploadFile()
    });
    async function uploadFile()
            {
             showLoader(); // Show loader at start of upload

              const file = fileInput.files[0];
              const fileType = file.type;
               if (!file) {
                   alert('Please select a video file.');
                   return;
               }
               const formData = new FormData();
                if (fileType.startsWith('image/')) {
                 formData.append('image', file);
                 type='image'
                }
                 else if (fileType.startsWith('video/')) {
                  formData.append('video', file);
                  type='video'
               }
            try {
                   const response = await fetch('/upload', {
                       method: 'POST',
                       body: formData
                   });

                   const result = await response.json();
                   console.log(result);
                   if (response.ok) {

                         imgPreview.style.display = 'none';
                         videoPreview.style.display = 'none';

                      if (file) {
                        const fileURL = URL.createObjectURL(file);
                        previewContainer.style.display = 'block'; // Show preview container

                        // Show image preview if the file is an image
                        if (fileType.startsWith('image/')) {
                          imgPreview.src = fileURL;
                          imgPreview.style.display = 'block';
                           selectedFilePath = result.path; // Store the file path returned by the server
                           console.log("Server File Path:", selectedFilePath); // Display the file path in the console
                        }
                        // Show video preview if the file is a video
                        else if (fileType.startsWith('video/')) {
                          videoPreview.src = fileURL;
                          videoPreview.style.display = 'block';

                          // Load metadata to get the duration
                          videoPreview.onloadedmetadata = function() {
                           duration = videoPreview.duration.toFixed(2); // Get duration in seconds
                            console.log("duration::"+duration)
                            selectedFilePath = result.path; // Store the file path returned by the server
                            console.log("Server File Path:", selectedFilePath); // Display the file path in the console
                            };

                        }

                      }
               // document.getElementById('result').innerText = result.message;
                   } else {
                     //  document.getElementById('result').innerText = 'Failed to upload video';
                   }
               } catch (error) {
                   console.error('Error:', error);
                  // document.getElementById('result').innerText = 'Error uploading video';
               }
               finally {
                   hideLoader(); // Hide loader after upload completes
                 }
           }

    async function uploadImage()
    {

                    const file = fileInput.files[0];

                    if (!file) {
                        alert('Please select a video file.');
                          return;
                     }

                    const formData = new FormData();
                    formData.append('video', file);

                    try {
                     const response = await fetch('/upload', {
                     method: 'POST',
                     body: formData
                     });

                     const result = await response.json();
                     console.log(result);

                     if (response.ok) {
                       document.getElementById('result').innerText = result.message;
                        }
                        else {
                         document.getElementById('result').innerText = 'Failed to upload video';
                            }
                          }
                           catch (error) {
                            console.error('Error:', error);
                            document.getElementById('result').innerText = 'Error uploading video';
                            }

    }
    console.log("upload js System ID:",deviceID);
    function getSystemId()
           {
             let systemId = localStorage.getItem('systemId');
             if (!systemId) {
                systemId = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                const r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
                return v.toString(16);
                 });
                 localStorage.setItem('systemId', systemId);
                 }
                return systemId;
       }
   async function addPlaylistItem()
    {
       const file = fileInput.files[0];

                     // Construct the full URL with query parameters
                    // const apiUrl = `http://192.168.31.32:8080/addPlaylistItem?url=${url}&type=${type}&duration=${duration}&deviceId=${deviceId}`;
       if (!file) {
       alert('Please select a video/image file.');
       return;
      }
      const formData = new URLSearchParams();
      formData.append('type', type);
      formData.append('duration', duration);
      formData.append('deviceId', deviceID);
      formData.append('url', selectedFilePath);
      // Print FormData contents
       printFormData(formData);  // Log the FormData entries
       showLoader(); // Show loader at start of upload

       try
         {
          const response = await fetch('/addPlaylistItem',
          {
          method: 'POST',
          headers:
                 {
                 'Content-Type': 'application/x-www-form-urlencoded'
                 },
                 body: formData
                 });
          const result = await response.json();

           // Check if the login was successful
           if (result.status === "success") {
               alert(result.message); // Display the message from the server
               settings()
           }
           else{
            alert(result.message); // Display the message from the server
           }
        }
        catch (error)
        {
         console.error('Error:', error);
         alert('Error connecting to server');
        }
        finally{
            hideLoader();
        }

       }
 // Use an event listener for the submit button
    document.getElementById('submitButton').addEventListener('click', addPlaylistItem);

    function printFormData(formData) {
        for (let [key, value] of formData.entries()) {
            console.log(`${key}:`, value);
        }
    }
}