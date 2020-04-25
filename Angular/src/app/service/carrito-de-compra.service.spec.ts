import { TestBed } from '@angular/core/testing';

import { CarritoDeCompraService } from './carrito-de-compra.service';

describe('CarritoDeCompraService', () => {
  let service: CarritoDeCompraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarritoDeCompraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
