# Banka Kredi Sistemi

## Proje Açıklaması
Bu proje, bir bankanın kredi sistemini yöneten Spring Boot tabanlı bir mikroservis uygulamasıdır. Sistem, bireysel ve kurumsal müşterilerin yönetimini sağlar.

## Teknolojiler
- Java 17
- Spring Boot 3.2.3
- PostgreSQL
- Maven
- MapStruct
- Lombok
- Swagger/OpenAPI

## Proje Yapısı
Proje, modüler bir yapıda tasarlanmış olup aşağıdaki modüllerden oluşmaktadır:

### 1. credit-core
- Temel utility sınıfları
- Ortak exception'lar
- Result yapıları

### 2. credit-entities
- JPA entity sınıfları
- Abstract ve concrete entity'ler
- Müşteri tipleri (Bireysel ve Kurumsal)

### 3. credit-repositories
- JPA repository interfaces
- Custom repository metodları
- PostgreSQL entegrasyonu

### 4. credit-business
- İş mantığı katmanı
- DTO (Data Transfer Objects)
- Mapping işlemleri (MapStruct)
- Validation kuralları

### 5. credit-webapi
- REST controller'lar
- Swagger/OpenAPI entegrasyonu
- Exception handling
- API endpoint'leri

## Özellikler
- Bireysel ve kurumsal müşteri yönetimi
- Müşteri bilgilerinin validasyonu
- REST API endpoints
- Swagger ile API dokümantasyonu
- PostgreSQL veritabanı entegrasyonu

## Kurulum
1. PostgreSQL veritabanını kurun ve `creditdb` adında bir veritabanı oluşturun
2. Projeyi klonlayın:
```bash
git clone https://github.com/kadirn7/BankApp-withJava.git
```
3. Proje dizinine gidin:
```bash
cd BankApp-withJava
```
4. Maven ile projeyi derleyin:
```bash
mvn clean install
```
5. Uygulamayı başlatın:
```bash
mvn spring-boot:run -pl credit-webapi
```

## API Dokümantasyonu
Swagger UI: `http://localhost:8080/swagger-ui/index.html`
OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Veritabanı Şeması
- customers (abstract)
  - id
  - customer_number
  - email
  - phone_number
  - address

- individual_customers
  - first_name
  - last_name
  - national_identity
  - birth_date

- corporate_customers
  - company_name
  - tax_number
  - trade_register_number

## Katkıda Bulunma
1. Bu repository'yi fork edin
2. Feature branch'i oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'feat: Add some amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

