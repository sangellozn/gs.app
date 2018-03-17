import { environment } from 'environments/environment';

const BASE_URL = environment.baseApiUrl + environment.restUrl;

const SHOPPING_LISTS_URL = BASE_URL + '/shoppinglists';
const PRODUCTS_URL = BASE_URL + '/products';

export const shoppingListsUrls = {
    create: `${SHOPPING_LISTS_URL}/create`,
    close: `${SHOPPING_LISTS_URL}/close`,
    current: `${SHOPPING_LISTS_URL}/current`
};

export const productsUrls = {
    getPage: `${PRODUCTS_URL}`,
    get: `${PRODUCTS_URL}/{id}`,
    create: `${PRODUCTS_URL}`,
    update: `${PRODUCTS_URL}/{id}`,
    delete: `${PRODUCTS_URL}/{id}`,
    count: `${PRODUCTS_URL}/actions/count`,
    stockRemove: `${PRODUCTS_URL}/{id}/stockremove`
};
