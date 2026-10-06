import settings from "./settings.js";
import popup from "./popup.js";
let body = document.querySelector('body')
export default function playlist() {
    body.innerHTML = `
   <section class="wrapper">
       <div class="containers display_flex">
               <div class="display_flex_col remotebar">
               <div class="display_flex w-100" style="margin-bottom:30px">
               <svg id="back" width="28" height="50" viewBox="0 0 28 50" fill="none" xmlns="http://www.w3.org/2000/svg">
               <path fill-rule="evenodd" clip-rule="evenodd" d="M7.11192 25L27.9457 45.8338L23.7796 50L0.862659 27.0831C0.310299 26.5306 0 25.7813 0 25C0 24.2187 0.310299 23.4694 0.862659 22.9169L23.7796 0L27.9457 4.16617L7.11192 25Z" fill="#0080E1"/>
               </svg>
               <h1 style="color:#0080E1;">Playlists</h1>
               <button class="btn deleteall delete display_flex" style="color: #ED8D8D;border-radius: 6px;background: none;"><svg style="margin-right:10px" width="19" height="24" viewBox="0 0 19 24" fill="none" xmlns="http://www.w3.org/2000/svg">
               <path d="M15.0431 8.08707V21.1306H4.60836V8.08707H15.0431ZM13.0866 0.260986H6.56488L5.26053 1.56533H0.695312V4.17403H18.9562V1.56533H14.391L13.0866 0.260986ZM17.6518 5.47838H1.99966V21.1306C1.99966 22.5653 3.17357 23.7392 4.60836 23.7392H15.0431C16.4779 23.7392 17.6518 22.5653 17.6518 21.1306V5.47838Z" fill="#ED8D8D"/>
               </svg><span>&nbsp;Delete Playlist</span></button>
               </div>

               </div>

<div class="display_flex_col listdiv" id="draggable-list">


</div>
        <button id="submit" class="bluebtn btn w-100" style="background: #0080E1;font-size: clamp(20px,3vw,40px);padding: 20px;">Save & Start Playing</button>
    </section>
    <div class="popup"></div>

    `
    document.getElementById('back').addEventListener('click', function () {
        settings(); // Call the playlist function when clicked
    });
    let deleteAllPlaylist = document.querySelector('.delete')
    if (window.matchMedia("(max-width: 768px)").matches) {
        deleteAllPlaylist.children[1].innerText = ""
    }
    else {
        deleteAllPlaylist.children[1].innerText = "Delete Playlist"
    }

    // Handle Delete button
    document.querySelector('.delete').addEventListener('click', function () {
        // Show a confirmation dialog before proceeding with deletion
        const isConfirmed = confirm('Are you sure you want to delete all items?');
        if (isConfirmed) {
            deleteAllPlaylistItem();
        }


    });
    async function fetchPlaylists() {
        try {
            const response = await fetch('/getAllPlaylist'); // Adjust this URL as needed
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            const result = await response.json();
            // Print the entire JSON response to the console
            console.log('Fetched JSON data:', result);
            if (result.status === "success") {
                // list(result.data)
                displayPlaylists(result.data); // Call function to display playlists
            } else {
                alert(result.message); // Display the error message if not successful
            }
        } catch (error) {
            console.error('Error fetching playlists:', error);
            alert('Failed to load playlists');
        }
    }

    function displayPlaylists(playlists) {
        let listdiv = document.querySelector(".listdiv")
        // Clear existing content to avoid duplicating items
          listdiv.innerHTML = "";
        playlists.forEach(item => {

            if (playlists.length === 0) {
                listdiv.innerHTML = '<p>No playlists available.</p>';
                return;
            }

            listdiv.innerHTML += `<div class="list display_flex draggable-item" draggable="true" data-id="${item.id}">
                                           <div class="display_flex">
                                              <img class="iconImage" src="/static/Icon.png" alt="">
                                                <!-- Video element (hidden, used for generating the thumbnail) -->
                                                  <video class="videoFile" style="display: none;"></video>
                                               <div class="display_flex_col">
                                                      <p style="font-size: clamp(20px, 3vw, 34px)" class="fontBold">${item.type}</p>
                                                      <p class="font-300 path">${item.url}</p>
                                                      <p class="font-300 id" style="display: none;">${item.id}</p> <!-- Hidden -->
                                                      <p class="font-300 thumbnailUrl" style="display: none;" >${item.thumbnailImage}</p> <!-- Hidden -->
                                                      <p class="font-300 duration" style="display: none;">${item.duration}</p> <!-- Hidden -->
                                                      <p class="font-300 type" style="display: none;">${item.type}</p> <!-- Hidden -->
                                                      <p class="font-300 deviceId" style="display: none;">${item.deviceId}</p> <!-- Hidden -->
                                                      <p class="font-300 rotationAngle" style="display: none;">${item.rotationAngle}</p> <!-- Hidden -->

                                                  </div>
                                           </div>
                                           <div class="display_flex">
<div class="display_flex" >
           <svg class="rotateicon arrow" width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg" style="display: none;">
<path d="M26.6667 23V31C26.6667 31.7073 26.3857 32.3855 25.8856 32.8856C25.3855 33.3857 24.7072 33.6667 24 33.6667H10.6667C9.95942 33.6667 9.28115 33.3857 8.78105 32.8856C8.28095 32.3855 8 31.7073 8 31V23C8 22.2928 8.28095 21.6145 8.78105 21.1144C9.28115 20.6143 9.95942 20.3333 10.6667 20.3333H24C24.7072 20.3333 25.3855 20.6143 25.8856 21.1144C26.3857 21.6145 26.6667 22.2928 26.6667 23ZM21.2187 8.21868L18.4373 11H21.3333C24.1623 11 26.8754 12.1238 28.8758 14.1242C30.8762 16.1246 32 18.8377 32 21.6667H29.3333C29.3333 17.256 25.744 13.6667 21.3333 13.6667H18.4373L21.2187 16.448L19.3333 18.3333L13.3333 12.3333L15.2187 10.448L19.3333 6.33334L21.2187 8.21868Z" fill="white" fill-opacity="0.5"/>
</svg>

<svg class="rotateicon arrow"  width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg" style="display: none;">
<path d="M13.3333 23V31C13.3333 31.7073 13.6143 32.3855 14.1144 32.8856C14.6145 33.3857 15.2928 33.6667 16 33.6667H29.3333C30.0406 33.6667 30.7189 33.3857 31.219 32.8856C31.719 32.3855 32 31.7073 32 31V23C32 22.2928 31.719 21.6145 31.219 21.1144C30.7189 20.6143 30.0406 20.3333 29.3333 20.3333H16C15.2928 20.3333 14.6145 20.6143 14.1144 21.1144C13.6143 21.6145 13.3333 22.2928 13.3333 23ZM18.7813 8.21868L21.5627 11H18.6667C15.8377 11 13.1246 12.1238 11.1242 14.1242C9.12381 16.1246 8 18.8377 8 21.6667H10.6667C10.6667 17.256 14.256 13.6667 18.6667 13.6667H21.5627L18.7813 16.448L20.6667 18.3333L26.6667 12.3333L24.7813 10.448L20.6667 6.33334L18.7813 8.21868Z" fill="white" fill-opacity="0.5"/>
</svg>
</div>
<div class="display_flex" >
      <svg class="up arrow"  width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
<path d="M20 12.5L32.9904 23.75H7.00962L20 12.5Z" fill="white" fill-opacity="0.5"/>
</svg>

<svg  class="down arrow" width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
<path d="M20 27.5L32.9904 16.25H7.00962L20 27.5Z" fill="white" fill-opacity="0.5"/>
</svg>
</div>
<div class="display_flex" >
  <svg class="listclick arrow" width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
   <path fill-rule="evenodd" clip-rule="evenodd" d="M9.5 32H30.5C30.8978 32 31.2794 32.158 31.5607 32.4393C31.842 32.7206 32 33.1022 32 33.5C32 33.8978 31.842 34.2794 31.5607 34.5607C31.2794 34.842 30.8978 35 30.5 35H9.5C9.10218 35 8.72064 34.842 8.43934 34.5607C8.15804 34.2794 8 33.8978 8 33.5C8 33.1022 8.15804 32.7206 8.43934 32.4393C8.72064 32.158 9.10218 32 9.5 32ZM8 24.5L23 9.5L27.5 14L12.5 29H8V24.5ZM24.5 8L27.5 5L32 9.5L28.9985 12.5015L24.5 8Z" fill="white" fill-opacity="0.5"/>
   </svg>
<svg  class="arrow deleteplay deleteicon"  width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
<path d="M26.6654 15V31.6667H13.332V15H26.6654ZM24.1654 5H15.832L14.1654 6.66667H8.33203V10H31.6654V6.66667H25.832L24.1654 5ZM29.9987 11.6667H9.9987V31.6667C9.9987 33.5 11.4987 35 13.332 35H26.6654C28.4987 35 29.9987 33.5 29.9987 31.6667V11.6667Z" fill="white" fill-opacity="0.5"/>
</svg>


</div>

                                           </div>
                                       </div>`

            // Get the last added iconImage (within the current item)
            const iconImages = document.querySelectorAll('.iconImage');
            const currentIconImage = iconImages[iconImages.length - 1];

            const videoFileInput = document.querySelectorAll('.videoFile');
            const currentVideoFileInput = videoFileInput[videoFileInput.length - 1];

            // Set the src based on item.type
            switch (item.type) {
                case 'video':
                    currentIconImage.src = '/static/video.png'; // Change this path to your video icon

                    /*const videoElement = currentVideoFileInput;
                     const thumbnailImage = currentIconImage;
                      const url = item.url;
                      // When the metadata of the video is loaded, we can extract a frame
                       videoElement.addEventListener('loadedmetadata', function() {
                         // Set the video to the first second
                         videoElement.currentTime = 1;

                         // Once the seeked time is set, draw the thumbnail on a canvas
                         videoElement.addEventListener('seeked', function() {
                             const canvas = document.createElement('canvas');
                             canvas.width = videoElement.videoWidth;
                             canvas.height = videoElement.videoHeight;

                             const context = canvas.getContext('2d');
                             context.drawImage(videoElement, 0, 0, canvas.width, canvas.height);

                             thumbnailImage.src = canvas.toDataURL();
                             thumbnailImage.style.display = 'block';

                             URL.revokeObjectURL(url);
                         });
                     });*/

                    break;
                case 'webpage':
                    currentIconImage.src = '/static/web.png'; // Change this path to your webpage icon
                    break;
                case 'image':
                    currentIconImage.src = '/static/Icon.png'; // Change this path to your image icon
                    break;
                default:
                    currentIconImage.src = '/static/Icon.png'; // Fallback if the type is unknown
                    break;
            }
        });








        let lists = document.querySelectorAll('.listclick')

        lists.forEach((item, index) => item.addEventListener('click', function () {
            /* popup(); // Call the playlist function when clicked
             console.log("asdkj")
             let path = document.querySelectorAll('.path');
             let filepath = document.querySelector('.filepath')
             filepath.innerText = path[index].innerText


             let duration = document.querySelectorAll('.duration');
             let pl = document.querySelector('.filepath')
             filepath.innerText = path[index].innerText
             */

            let path = document.querySelectorAll('.path')[index].innerText;
            let duration = document.querySelectorAll('.duration')[index].innerText;
            let type = document.querySelectorAll('.type')[index].innerText;
            let deviceId = document.querySelectorAll('.deviceId')[index].innerText;
            let id = document.querySelectorAll('.id')[index].innerText;
            let selectedRotationAngle=document.querySelectorAll('.rotationAngle')[index].innerText;


            // Call the popup function with the current path and duration
            popup(selectedRotationAngle,"playlist", id, deviceId, type, path, duration);





            // let id = document.querySelectorAll('.id')
            //  let selId = document.querySelector('.id')
            //  selId.innerText = id[index].innerText
            //  console.log(index, path[index].innerText)

        }));
        const upButtons = document.querySelectorAll('.up');
        const downButtons = document.querySelectorAll('.down');
        const deleteButtons = document.querySelectorAll('.deleteicon');
        deleteButtons.forEach(button => {
            button.addEventListener('click', () => {
                const item = button.closest('.list');
                const itemId = item.querySelector('.id').innerText;
                const isConfirmed = confirm('Are you sure you want to delete this item?');
                if (isConfirmed) {
                    deletePlaylistItem(itemId);
                }
            });
        });

        upButtons.forEach(button => {
            button.addEventListener('click', () => {
                const item = button.closest('.list');
                const previousItem = item.previousElementSibling;
                if (previousItem) {
                    item.parentNode.insertBefore(item, previousItem);
                    //   updateOrder(); // Call function to update the order on the server
                }
            });
        });

        downButtons.forEach(button => {
            button.addEventListener('click', () => {
                const item = button.closest('.list');
                const nextItem = item.nextElementSibling;
                if (nextItem) {
                    item.parentNode.insertBefore(nextItem, item);
                }
            });
        });
    }
    //       Function to update the order of the playlist on the server
    // Function to update the order of the playlist on the server

    document.getElementById('submit').addEventListener('click', function () {
        updateOrder(); // Call the playlist function when clicked
    });

    function updateOrder() {
        const listItems = document.querySelectorAll('.list');
        if (listItems.length === 0) {
            alert("No playlists available. Cannot save the playlist items.");
            return;
        }

        const updatedPlaylist = [];
        console.log("listItems::" + listItems)
        listItems.forEach((item, index) => {
            const itemId = item.querySelector('.id').innerText;
            const itemType = item.querySelector('.fontBold').innerText;
            const itemUrl = item.querySelector('.path').innerText;
            const itemThumbUrl = item.querySelector('.thumbnailUrl').innerText;
            const itemDuration = item.querySelector('.duration').innerText;
            const itemDeviceId = item.querySelector('.deviceId').innerText;

            const itemName = "";
            const orientation = "";
            const resize_mode = "";
            const subTitle = "";

            // Ensure that ID, type, and URL are not empty

            updatedPlaylist.push({
                // id: itemId,
                order: index, // Use index as the new order
                type: itemType,
                url: itemUrl,
                thumbnailImage: itemThumbUrl,
                deviceId: itemDeviceId,  // Hardcoded device ID
                duration: itemDuration,
                lastModified: Date.now(),     // Use current timestamp
                name: itemName,
                orientation: orientation,
                resize_mode: resize_mode,
                subTitle: subTitle,
            });
        });

        if (updatedPlaylist.length === 0) {
            console.error('No valid playlist items to send.');
            return;
        }

        // Prepare data for sending
        const requestData = JSON.stringify({ data: updatedPlaylist });

        // Log the request payload
        console.log("Request payload:", requestData);

        // Fetch request to the server
        fetch('/addAllPlaylistItem', {  // Ensure the full URL
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: requestData,
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                if (data.status === 'success') {
                    console.log('Order updated successfully:', data);

                    settings()
                } else {
                    console.error('Failed to update order:', data.message);
                }
            })
            .catch(error => {
                console.error('Failed to update order:', error);
            });
    }
    function deletePlaylistItem(id) {
        // Validate if the ID is valid (non-empty, numeric, etc.)
        if (!id || isNaN(id)) {
            alert("Invalid ID. Cannot delete playlist item.");
            return; // Stop execution if validation fails
        }

        // Construct the request URL with the ID parameter
        const url = '/deletePlaylistItem?id='+id;

        // Send the DELETE request using the fetch API
        fetch(url, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'multipart/form-data' // Not always necessary, depending on server setup
            },
            body: new FormData().append('id', id) // Send the ID as form data, similar to your curl request
        })
            .then(response => response.json()) // Parse the JSON response
            .then(data => {
                // Check the status in the JSON response
                if (data.status === 'success') {
                    console.log(`Item deleted successfully. Deleted Item ID: ${data.deletedItemId}`);
                    alert("Item deleted successfully.");
                    fetchPlaylists();
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
    function deleteAllPlaylistItem() {
        const listItems = document.querySelectorAll('.list');
        if (listItems.length === 0) {
            alert("No playlists available. Cannot delete playlist items.");
            return;
        }
        // Construct the request URL with the ID parameter
        const url = `/deleteAllPlaylistItems`;

        // Send the DELETE request using the fetch API
        fetch(url, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'multipart/form-data' // Not always necessary, depending on server setup
            },
            // body: new FormData().append('id', id) // Send the ID as form data, similar to your curl request
        })
            .then(response => response.json()) // Parse the JSON response
            .then(data => {
                // Check the status in the JSON response
                if (data.status === 'success') {
                  //  console.log("Item deleted successfully. Deleted Item ID: ${data.deletedItemId}");
                    alert("All Items deleted successfully.");
                    fetchPlaylists();
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

    fetchPlaylists();
}