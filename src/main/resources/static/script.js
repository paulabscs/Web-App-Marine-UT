document.addEventListener('DOMContentLoaded', function () {

    // Initialize variables
    const homeTab = document.getElementById('home-tab');
    const sharksTab = document.getElementById('sharks-tab');
    const homeSection = document.getElementById('home-section');
    const sharksSection = document.getElementById('sharks-section');
    const sharksList = document.getElementById('sharks-list');
    const prevPageButton = document.getElementById('prev-page');
    const nextPageButton = document.getElementById('next-page');
    let currentPage = 0;

    // Function to get port
    /* Provides the base URL for API requests */
    function getPort() {
        return 'http://localhost:8080'; // Adjust if needed
    }

    // Function to fetch shark data from the server
    /* Fetches shark data based on the current page */
    async function fetchSharks() {
        sharksList.innerHTML = 'Loading sharks...';

        try {
            const response = await fetch(`${getPort()}/api/get_marines?offset=${currentPage * 10}&limit=10`);
            const data = await response.json();
            updateSharksTable(data);
        } catch (error) {
            sharksList.innerHTML = 'Failed to load sharks.';
            console.error('Error fetching sharks:', error);
        }
    }

    // Function to update shark table with new data
    /* Clears and repopulates shark table with the current page's data */
    function updateSharksTable(data) {
        sharksList.innerHTML = '';
        const table = document.createElement('table');
        table.innerHTML = `
            <thead>
                <tr>
                    <th>#</th>
                    <th>Species</th>
                    <th>Size</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody></tbody>
        `;

        data.forEach((shark, index) => {
            const dimensions = shark.size;
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${index + 1 + currentPage * 10}</td>
                <td>${shark.species}</td>
                <td>${dimensions.length}m x ${dimensions.width}m x ${dimensions.height}m</td>
                <td>${shark.age} years</td>
            `;
            table.querySelector('tbody').appendChild(row);
        });

        sharksList.appendChild(table);

        prevPageButton.disabled = currentPage === 0;
        nextPageButton.disabled = data.length < 10;
    }

    // Function to fetch API version
    /* Retrieves and displays the API version */
    async function fetchVersion() {
        const versionDiv = document.getElementById('version-display');
        try {
            const response = await fetch(`${getPort()}/api/get_version`);
            const data = await response.json();
            versionDiv.textContent = `Version: ${data.version}`;
        } catch (error) {
            versionDiv.textContent = 'Failed to load version.';
            console.error('Error fetching version:', error);
        }
    }

    // Function to show sections
    /* Toggles between home and sharks sections */
    function showSection(section) {
        homeSection.style.display = section === 'home' ? 'block' : 'none';
        sharksSection.style.display = section === 'sharks' ? 'block' : 'none';
    }

    // Event listeners for tab navigation
    /* Handles tab navigation to switch sections */
    homeTab.addEventListener('click', function () {
        showSection('home');
    });

    sharksTab.addEventListener('click', function () {
        showSection('sharks');
        fetchSharks();
    });

    // Event listeners for pagination
    /* Handles page navigation for shark data */
    prevPageButton.addEventListener('click', function () {
        if (currentPage > 0) {
            currentPage--;
            fetchSharks();
        }
    });

    nextPageButton.addEventListener('click', function () {
        currentPage++;
        fetchSharks();
    });

    // Initialize the app
    /* Loads the initial version and home section */
    fetchVersion();
    showSection('home');
});
