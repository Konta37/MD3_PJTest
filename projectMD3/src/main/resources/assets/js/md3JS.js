function searchCategory() {
    const query = document.getElementById('searchInput').value;
    if (query.length > 0) {
        fetch(`/searchCategory?query=${query}`)
            .then(response => response.json())
            .then(categories => {
                const categoryList = document.getElementById('categoryList');
                categoryList.innerHTML = ''; // Clear the list
                categories.forEach(category => {
                    const li = document.createElement('li');
                    // li.innerHTML = `<a href="/searchCategory?id=${category.id}">${category.categoryName}</a>`;
                    li.innerHTML = `<span th:text="${category.categoryName}">Category Name</span></a>`;
                    categoryList.appendChild(li);
                });
            });
    }
}