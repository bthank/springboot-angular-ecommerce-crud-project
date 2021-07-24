import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'; // from rxjs which is reactive javaScript library

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  // url for SpringBoot REST api
  private baseUrl = 'http://localhost:8080/api/products';

  // inject the   HttpClient using Angular's injection framework
  constructor(private httpClient: HttpClient) { }

  // method to map the JSON data from the Spring Data REST service to Product array
  getProductList(): Observable<Product[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.products)
    );
  }
}

// unwraps the JSON from Spring Data REST _embedded entry
interface GetResponse {
  _embedded: {
    products: Product[];
  }
}