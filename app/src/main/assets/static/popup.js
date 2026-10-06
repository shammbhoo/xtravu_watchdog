import settings from "./settings.js";

/* Parameters for existing playlist item */
export default function popup(selectedRotationAngle='',callFrom = '',id = '', deviceId = '', type = '', selectedFilePath = 'No file selected', selectedDuration = '0.0') {
    let pop = document.querySelector('.popup');
    console.log(pop);
    pop.style.display = "flex"; // Show the popup

    // Initialize selected values
    let selectedFileType = type;
    let totalVideoDuration=selectedDuration
    let selectedId = id;
    let selectedDeviceId = deviceId;


    // Update the popup content and populate it with selected values
    pop.innerHTML = `
        <div class="layer display_flex">
            <div class="display_flex_col">
                <h1 class="fileTypeHeading" style="font-size: clamp(28px , 3vw,40px);">Edit Playlist Item</h1>
                <div class="display_flex_col">
                    <div class="display_flex_col">

                        <p class="fileType", style="color: #FFFFFF80;font-size: clamp(18px , 3vw,24px);" >File Location</p>
                       <input class="webUrl" type="text" value="" placeholder="Enter web url" style="background: none;padding: 10px;border-bottom: 1px solid #FFFFFF80;font-size: clamp(20px , 3vw,28px);max-width: 500px;overflow-x: scroll;">
                        <input type="file" class="fileInput" accept="image/*,video/*" style="display: none;">
<div class="display_flex">

<p class="filepath" value ="", style="background: none;width:60%;padding: 10px;border-bottom: 1px solid #FFFFFF80;font-size: clamp(20px , 3vw,28px);max-width: 500px;overflow-x: scroll;">${selectedFilePath}</p>
<button class="btn selectFileBtn" style="background-color: #FFFFFF1A;">Select File</button>
</div>

<p style="color: #FFFFFF80;font-size: clamp(18px , 3vw,24px);">Duration</p>
 <div class="display_flex">

                        <div class="display_flex" style=" width: 50%;">
                            <input class="videoDuration" type="text" value="" placeholder="00:00" style="width:100%;background: none;font-size: clamp(20px , 3vw,28px);padding: 10px;border-bottom: 1px solid #FFFFFF80;max-width: 200px;">
                            <p style="font-size: clamp(15px , 3vw,28px);    padding: 10px 0;">seconds</p>
                        </div>
                        <div class="display_flex" style=" width: 40%;max-width:95px">
                        <svg width="41" height="40" viewBox="0 0 41 40" fill="none" xmlns="http://www.w3.org/2000/svg">
<rect x="0.851562" width="40" height="40" rx="7.40741" fill="#2D2B2C"/>
<path d="M27.5182 23V31C27.5182 31.7072 27.2373 32.3855 26.7372 32.8856C26.2371 33.3857 25.5588 33.6666 24.8516 33.6666H11.5182C10.811 33.6666 10.1327 33.3857 9.63261 32.8856C9.13251 32.3855 8.85156 31.7072 8.85156 31V23C8.85156 22.2927 9.13251 21.6145 9.63261 21.1144C10.1327 20.6143 10.811 20.3333 11.5182 20.3333H24.8516C25.5588 20.3333 26.2371 20.6143 26.7372 21.1144C27.2373 21.6145 27.5182 22.2927 27.5182 23ZM22.0702 8.21865L19.2889 11H22.1849C25.0139 11 27.727 12.1238 29.7274 14.1242C31.7278 16.1246 32.8516 18.8377 32.8516 21.6666H30.1849C30.1849 17.256 26.5956 13.6666 22.1849 13.6666H19.2889L22.0702 16.448L20.1849 18.3333L14.1849 12.3333L16.0702 10.448L20.1849 6.33331L22.0702 8.21865Z" fill="white" fill-opacity="0.5"/>
</svg>

                      <svg width="41" height="40" viewBox="0 0 41 40" fill="none" xmlns="http://www.w3.org/2000/svg">
<rect x="0.257812" width="40" height="40" rx="7.40741" fill="#2D2B2C"/>
<path d="M13.5911 23V31C13.5911 31.7072 13.8721 32.3855 14.3722 32.8856C14.8723 33.3857 15.5506 33.6666 16.2578 33.6666H29.5911C30.2984 33.6666 30.9767 33.3857 31.4768 32.8856C31.9769 32.3855 32.2578 31.7072 32.2578 31V23C32.2578 22.2927 31.9769 21.6145 31.4768 21.1144C30.9767 20.6143 30.2984 20.3333 29.5911 20.3333H16.2578C15.5506 20.3333 14.8723 20.6143 14.3722 21.1144C13.8721 21.6145 13.5911 22.2927 13.5911 23ZM19.0391 8.21865L21.8205 11H18.9245C16.0955 11 13.3824 12.1238 11.382 14.1242C9.38162 16.1246 8.25781 18.8377 8.25781 21.6666H10.9245C10.9245 17.256 14.5138 13.6666 18.9245 13.6666H21.8205L19.0391 16.448L20.9245 18.3333L26.9245 12.3333L25.0391 10.448L20.9245 6.33331L19.0391 8.21865Z" fill="white" fill-opacity="0.5"/>
</svg>

                        </div>
                        </div>


                    </div>
                    <div class="display_flex_col">
                        
                        <div class="display_flex w-100">
                            <button class="btn deleteBtn" style="background-color:  #ED8D8D;">Delete</button>

                            <button class="btn cancel" style="background-color: #FFFFFF1A; ">Cancel</button>
                            <button class="btn save" style="background-color: #0080E1;">Save</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;
    // Handle file selection
    const webUrlInput = document.querySelector('.webUrl');
    const fileInput = document.querySelector('.fileInput');
    const filepathDisplay = document.querySelector('.filepath');
    const selectFileBtn = document.querySelector('.selectFileBtn');
    const deleteBtn = document.querySelector('.deleteBtn');
    const fileTypeBtn = document.querySelector('.fileType');
    const fileTypeHeading =document.querySelector('.fileTypeHeading');
    const durationInput = document.querySelector('.videoDuration'); // Select duration input here
    durationInput.value=selectedDuration
    webUrlInput.value=selectedFilePath
    selectFileBtn.addEventListener('click', () => {
       if (selectedFileType !== 'webpage') {
            fileInput.click(); // Open file dialog if not a webpage
        }
     });

    fileInput.addEventListener('change', (event) => {
    uploadFile();
    });

    // Handle cancel button
    document.querySelector('.cancel').addEventListener('click', function() {
        pop.style.display = "none"; // Hide the popup
    });
    deleteBtn.addEventListener('click', () => {
     const isConfirmed = confirm('Are you sure you want to delete this item?');
      if(isConfirmed){
         console.log("selectedID::",selectedId)
         deletePlaylistItem(selectedId);
       }
     });
    // Handle save button
    document.querySelector('.save').addEventListener('click', function() {
     if(callFrom ==="settings"){
         addPlaylistItem();
      }
      else{
        upDatePlaylistItemByLastModified();
      }

    });
      // Handle Delete button


    // deletePlaylistItem(selectedId);
   /* */


   // Hide "Select File" button if selectedFileType is "webpage"
       if (selectedFileType === 'webpage') {
           selectFileBtn.style.display = 'none'; // Hide the button
           filepathDisplay.style.display = 'none'; // Hide the button
           webUrlInput.style.display = 'inline-block'; // Show the button if it's not a webpage
           fileTypeBtn.innerText="Web Url"

           if(callFrom ==="settings"){
           deleteBtn.style.display = 'none';
            fileTypeHeading.innerText="Add Playlist Item"
           }
          else{
              deleteBtn.style.display = 'inline-block';
               fileTypeHeading.innerText="Edit Playlist Item"
           }
       } else {
           selectFileBtn.style.display = 'inline-block'; // Show the button if it's not a webpage
           filepathDisplay.style.display = 'inline-block'; // Show the button if it's not a webpage
           webUrlInput.style.display = 'none'; // Hide the button
           fileTypeBtn.innerText="File Location"
           fileTypeHeading.innerText="Edit Playlist Item"
       }

             async function uploadFile()
                {
                  const file = fileInput.files[0];
                  const fileType = file.type;
                   if (!file) {
                       alert('Please select a video file.');
                       return;
                   }
                   const formData = new FormData();
                    if (fileType.startsWith('image/')) {
                     formData.append('image', file);
                     selectedFileType='image'
                    }
                     else if (fileType.startsWith('video/')) {
                      formData.append('video', file);
                      selectedFileType='video'
                   }
                  try {
                       const response = await fetch('/upload', {
                           method: 'POST',
                           body: formData
                       });

                       const result = await response.json();
                       console.log(result);
                       if (response.ok) {

                          if (file) {
                            const fileURL = URL.createObjectURL(file);

                            // Show image preview if the file is an image
                            if (fileType.startsWith('image/')) {
                               selectedFilePath = result.path; // Store the file path returned by the server
                               console.log("Server File Path:", selectedFilePath); // Display the file path in the console
                               filepathDisplay.innerText =selectedFilePath; // Display the selected file's name
                            }
                            // Show video preview if the file is a video
                            else if (fileType.startsWith('video/')) {

                              // Load metadata to get the duration

                              const videoElement = document.createElement('video'); // Create a temporary video element
                              videoElement.src = URL.createObjectURL(file); // Set the source to the selected file

                              videoElement.addEventListener('loadedmetadata', () => {
                              const videoDuration = videoElement.duration; // Get duration in seconds
                              console.log('Video duration:', videoDuration);

                               // Update the duration input with the video duration
                               const formattedDuration = formatDuration(videoDuration);
                               selectedDuration=videoDuration
                               totalVideoDuration=videoDuration
                               durationInput.value = selectedDuration; // Format the duration before updating
                               selectedFilePath = result.path; // Store the file path returned by the server
                               filepathDisplay.innerText =selectedFilePath; // Display the selected file's name
                              console.log('Updated Duration Input:', durationInput.value);
                               });
                            }

                          }

                       } else {

                       }
                   } catch (error) {
                       console.error('Error:', error);
                      // document.getElementById('result').innerText = 'Error uploading video';
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
                                  } else {
                                      document.getElementById('result').innerText = 'Failed to upload video';
                                  }
                              } catch (error) {
                                  console.error('Error:', error);
                                  document.getElementById('result').innerText = 'Error uploading video';
                              }
                          }
            async function upDatePlaylistItemByLastModified() {

             let updatedFilePath = filepathDisplay.innerText;
             let updatedDuration = durationInput.value;
             if(selectedFileType === 'webpage'){
               updatedFilePath = webUrlInput.value;
             }

              // Ensure that a file is selected
             // const file = fileInput.files[0];
             /* if (selectedFilePath) {
                  alert('Please select a video/image file.');
                  return;
              }*/

               // Apply validation for file path
              if (updatedFilePath === 'No file selected' || updatedFilePath.trim() === '') {
                 alert('Please select a valid file before saving.');
                 return; // Prevent the save operation if no valid file is selected
              }
            // Check if the filepath is a valid web URL
            if(selectedFileType === 'webpage'){
                 if (!isValidURL(updatedFilePath))
                  {
                   alert('Please enter valid Web url.');
                     console.log('File path is a valid web URL:', updatedFilePath);
                     return;
                  }

            }


            // Ensure the file path is provided
            if (!selectedFilePath || selectedFilePath === 'No file selected') {
                alert('Please select a file location.');
                return;
            }


              // Validate selected duration for video type
              if (selectedFileType === 'video' && updatedDuration > totalVideoDuration) {
                  alert(`Please enter a video duration between 0 and ${totalVideoDuration}.`);
                  return;
              }

              // Create URL-encoded form data
              const formData = new URLSearchParams({
                  id: selectedId,
                  name: "",                // Add the actual name if available
                  subTitle: "",            // Add the actual subtitle if available
                  resize_mode: "",         // Add the actual resize mode if available
                  orientation: "",         // Add the actual orientation if available
                  type: selectedFileType,
                  duration: updatedDuration,
                  deviceId: selectedDeviceId,
                  url: updatedFilePath ,    // You can replace this with the actual file URL if needed
                  rotationAngle:selectedRotationAngle
              });

              // Log the FormData entries (for debugging purposes)
              for (let entry of formData.entries()) {
                  console.log(`${entry[0]}: ${entry[1]}`);
              }

              try {
                  // Send POST request to update playlist item
                  const response = await fetch('/upDatePlaylistItemByLastModified', {
                      method: 'POST',
                      headers: {
                          'Content-Type': 'application/x-www-form-urlencoded'
                      },
                      body: formData.toString() // Convert URLSearchParams to string format
                  });

                  // Parse the JSON response from the server
                  const result = await response.json();

                  // Display the server message
                  alert(result.message);

                  // Check if the update was successful
                  if (result.status === "success") {
                      settings(); // Call settings function if the update is successful
                  }
              } catch (error) {
                  // Catch any network or server errors and log them
                  console.error('Error:', error);
                  alert('Error connecting to server. Please try again later.');
              }
          }
        function isValidURL(str) {
            try {
                new URL(str); // If this works, it's a valid URL
                return true;
            } catch (_) {
                return false; // If an error is thrown, it's not a valid URL
            }
        }

               // Function to delete a playlist item
               function deletePlaylistItem(selectedId) {
               // Validate if the ID is valid (non-empty, numeric, etc.)
                   if (!id || isNaN(id)) {
                       alert("Invalid ID. Cannot delete playlist item.");
                       return; // Stop execution if validation fails
                   }

                   // Construct the request URL with the ID parameter
                   const url = '/deletePlaylistItem?id='+selectedId;

                   // Send the DELETE request using the fetch API
                   fetch(url, {
                       method: 'DELETE',
                       headers: {
                           'Content-Type': 'multipart/form-data' // Not always necessary, depending on server setup
                       },
                       body: new FormData().append('id', selectedId) // Send the ID as form data, similar to your curl request
                   })
                   .then(response => response.json()) // Parse the JSON response
                   .then(data => {
                       // Check the status in the JSON response
                       if (data.status === 'success') {
                           console.log(`Item deleted successfully. Deleted Item ID: ${data.deletedItemId}`);
                           alert("Item deleted successfully.");
                           settings();
                           // Optionally remove the deleted item from the UI here
                       } else {
                           console.error('Failed to delete the playlist item:', data.message);
                           alert("Failed to delete the playlist item. " + data.message);
                       }
                   })
                   .catch(error => {
                       // Handle network errors
                       console.error('Error:', error);
                       alert("Error deleting the playlist item.");
                   });
               }
  async function addPlaylistItem()
    {
    let updatedFilePath = filepathDisplay.innerText;
    let updatedDuration = durationInput.value;
    if(selectedFileType === 'webpage'){
     updatedFilePath = webUrlInput.value;
    }
     if (updatedFilePath === 'No file selected' || updatedFilePath.trim() === '') {
     alert('Please select a valid file before saving.');
       return; // Prevent the save operation if no valid file is selected
    }
                  // Check if the filepath is a valid web URL
     if(selectedFileType === 'webpage'){
       if (!isValidURL(updatedFilePath))
       {
       alert('Please enter valid Web url.');
          console.log('File path is a valid web URL:', updatedFilePath);
          return;
       }

     }
      // Validate selected duration for video type
     if (updatedDuration <=0) {
        alert("Please enter the duration");
        return;
     }
      const formData = new URLSearchParams();
      formData.append('type', type);
      formData.append('duration', updatedDuration);
      formData.append('deviceId', selectedDeviceId);
      formData.append('url', updatedFilePath);
      // Print FormData contents
       printFormData(formData);  // Log the FormData entries

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
          alert(result.message); // Display the message from the server
           // Check if the login was successful
           if (result.status === "success") {
               settings()
           }
        }
        catch (error)
        {
         console.error('Error:', error);
         alert('Error connecting to server');
        }

       }
     // Use an event listener for the submit button
       // document.getElementById('submitButton').addEventListener('click', addPlaylistItem);
// Helper function to format duration in HH:MM:SS
    function formatDuration(seconds) {
        const hours = Math.floor(seconds / 3600);
        const minutes = Math.floor((seconds % 3600) / 60);
        const secs = Math.floor(seconds % 60);
        return `${hours > 0 ? hours + ':' : ''}${minutes < 10 ? '0' : ''}${minutes}:${secs < 10 ? '0' : ''}${secs}`;
    }
 function printFormData(formData) {
        for (let [key, value] of formData.entries()) {
            console.log(`${key}:`, value);
        }
    }
}

